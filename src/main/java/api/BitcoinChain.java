package api;

import com.google.gson.Gson;
import model.AddressData;
import model.AddressResponse;
import org.apache.commons.lang3.StringUtils;
import util.ApiHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitcoinChain {

    /**
     * Base URL to get balance from API
     */
    private static final String BALANCE_URL = "https://chain.api.btc.com/v3/address/";

    /**
     * Number of times to retry
     */
    private static int RETRY_LIMIT = 3;

    /**
     * Get balanced for a specified list of bitcoin addresses
     * @param addresses
     * @return
     */
    public static Map<String, Double> getBalances(List<String> addresses) {
        Map<String, Double> balances = new HashMap<String, Double>();

        String addressString = StringUtils.join(addresses, ',');

        int retryCount = 0;
        while (true) {
            try {
                String json = ApiHelper.readUrl(BALANCE_URL + addressString);
                AddressResponse response = new Gson().fromJson(json, AddressResponse.class);

                for (AddressData data : response.getData()) {
                    balances.put(data.getAddress(), ApiHelper.convertSatoshisToBitcoin(data.getBalance()));
                }

                return balances;
            } catch (IOException ex) {
                if (retryCount++ <= RETRY_LIMIT) continue;

                else {
                    System.out.println("Unable to retrieve balances");
                    ex.printStackTrace();
                    return null;
                }
            }
        }
    }
}
