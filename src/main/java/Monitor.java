import api.BitcoinChain;
import slack.SlackWebhook;
import util.Constants;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Monitor {

    /**
     * Interval in milliseconds to run process
     */
    private static final Long TIME_INTERVAL = 30 * 60 * 1000L;

    /**
     * Mt Gox wallet balances
     */
    private static Map<String, Double> existingBalances = new HashMap<>();

    /**
     * Empty constructor
     */
    public Monitor() {}

    /**
     * Initialize balances with the current state
     */
    public void initialize() {
        existingBalances = BitcoinChain.getBalances(Constants.MT_GOX_ADDRESSES);
    }

    /**
     * Compare current and previous values, monitor changes
     */
    public void run() {
        SlackWebhook slack = new SlackWebhook("mt-gox-movement");

        try {
            while (true) {
                Map<String, Double> currentBalances = BitcoinChain.getBalances(Constants.MT_GOX_ADDRESSES);

                for (Map.Entry<String, Double> entry : currentBalances.entrySet()) {
                    String address = entry.getKey();
                    Double currentBalance = entry.getValue();

                    Double existingBalance = existingBalances.get(address);
                    if (!existingBalance.equals(currentBalance)) {
                        /**
                         * Send slack alert regarding change
                         */
                        String message = String.format("Movement at address %s: from %s BTC to %s BTC", address, existingBalance.toString(), currentBalance.toString());
                        slack.sendMessage(message);

                        existingBalances.put(address, currentBalance);
                    }
                }

                System.out.println(new Timestamp(System.currentTimeMillis()) + " - sleeping...");
                Thread.sleep(TIME_INTERVAL);
            }
        } catch (InterruptedException ex) {
            slack.sendMessage("Error: " + ex.toString());
        }

        slack.shutdown();
    }
}
