import com.google.gson.Gson;
import model.blockchain.RawOut;
import model.blockchain.rawaddress.RawAddressResponse;
import model.blockchain.rawaddress.RawAddressTransactions;
import model.coindesk.HistoricalPrice;
import org.javatuples.Triplet;
import org.joda.time.DateTime;
import util.ApiHelper;
import util.Constants;
import util.TimeHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class History {

    /**
     * Transaction amount threshold for analysis
     */
    private static final Double MINIMUM_BITCOIN_THRESHOLD = 1000.0;

    /**
     * Number of days after a transaction to check
     */
    private static final Integer DAY_RANGE = 10;

    /**
     * Base url for raw address API
     */
    private static final String RAW_ADDRESS_URL = "https://blockchain.info/rawaddr/";

    /**
     * Base url for coin desk historical price checker
     */
    private static final String COINDESK_PRICE_URL = "https://api.coindesk.com/v1/bpi/historical/close.json?";

    /**
     * Transaction was relayed by this node
     */
    private static final String SELF_RELAYED = "0.0.0.0";

    private Gson gson;

    public History() {
        gson = new Gson();
    }

    public void analyze() {
        List<Triplet<String, Double, Map<String, Double>>> transactionImpact = new ArrayList<>();

        for (String mtGoxAddress : Constants.MT_GOX_ADDRESSES) {
            System.out.println("Checking transactions for address " + mtGoxAddress);

            try {
                String json = ApiHelper.readUrl(RAW_ADDRESS_URL + mtGoxAddress);
                RawAddressResponse response = gson.fromJson(json, RawAddressResponse.class);

                /**
                 * The bitcoin network doesn't store an actual timestamp for each transaction due to its nature of decentralization.
                 * A workaround is to find the transaction that was relayed by the Blockchain Info node
                 * and find the timestamp accordingly, which is the time that the specific node was made aware of the tx
                 */
                List<RawAddressTransactions> selfTransactions = response.getTransactions()
                        .stream()
                        .filter(t -> t.getRelayedBy().equals(SELF_RELAYED))
                        .collect(toList());

                if (selfTransactions.size() == 0) continue;

                Long transactionTimestamp = selfTransactions.iterator()
                        .next()
                        .getTime();

                /**
                 * Filter transactions to only those sent by the respective address and that meet the minimum threshold
                 * For duplicate block heights, merge the transactions
                 */
                Map<Long, List<RawOut>> transactionTimeMap = response.getTransactions()
                        .stream()
                        .collect(Collectors.toMap(
                                t -> t.getBlockHeight(),
                                t -> t.getOut()
                                        .stream()
                                        .filter(o -> ApiHelper.convertSatoshisToBitcoin(o.getValue()) > MINIMUM_BITCOIN_THRESHOLD)
                                        .filter(o -> o.getAddress().equals(mtGoxAddress))
                                        .collect(toList()),
                                (txList1, txList2) -> Stream.concat(txList1.stream(), txList2.stream())
                                        .collect(toList())));

                /**
                 * Remove transactions that don't meet the criteria
                 */
                Map<Long, List<RawOut>> validTransactionTimeMap = transactionTimeMap.entrySet()
                        .stream()
                        .filter(kv -> kv.getValue().size() > 0)
                        .collect(Collectors.toMap(entry -> transactionTimestamp, entry -> entry.getValue()));

                /**
                 * For each valid transaction, check the prices for each of the following 10 days
                 */
                for (Map.Entry<Long, List<RawOut>> transactionTimeEntry : validTransactionTimeMap.entrySet()) {
                    List<RawOut> sentTransactions = transactionTimeEntry.getValue();
                    Double amountSent = ApiHelper.convertSatoshisToBitcoin(sentTransactions
                            .stream()
                            .mapToDouble(t -> t.getValue())
                            .sum());

                    /**
                     * Find start period and end period (add 10 days)
                     */
                    DateTime datetime = TimeHelper.convertUnixTimestampToDateTime(transactionTimeEntry.getKey());
                    String startPeriod = TimeHelper.extractDate(datetime);
                    String endPeriod = TimeHelper.addDaysToDate(startPeriod, DAY_RANGE);

                    /**
                     * Find daily prices between start and end period
                     */
                    String priceUrl = COINDESK_PRICE_URL + "start=" + startPeriod + "&end=" + endPeriod;
                    String priceJson = ApiHelper.readUrl(priceUrl);
                    HistoricalPrice historicalPrice = gson.fromJson(priceJson, HistoricalPrice.class);

                    /**
                     * Accumulate triplets of start date, total amount sent, map of following 10 days with prices
                     */
                    transactionImpact.add(new Triplet<>(mtGoxAddress, amountSent, historicalPrice.getBpi()));
                }
            } catch (IOException ex) {
                System.out.println("Error with address: " + mtGoxAddress);
                ex.printStackTrace();
            }
        }

        /**
         * Order entries by the date of the initial transaction
         */
        Collections.sort(transactionImpact,
                Comparator.comparing(t -> t.getValue2()
                        .entrySet()
                        .iterator()
                        .next()
                        .getKey()));

        for (Triplet<String, Double, Map<String, Double>> tx : transactionImpact) {
            System.out.println(tx);
        }

    }
}
