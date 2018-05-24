package util;

import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class ApiHelper {

    /**
     * Number of satoshis in one unit
     */
    private static final Double SATOSHIS = 100000000.0;

    /**
     * User agent for HTTPS connection
     */
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";

    /**
     * UTF-8 encoding for reading text
     */
    private static final String ENCODING = "UTF-8";

    /**
     * Read JSON from url
     * @param urlString
     * @return
     * @throws IOException
     */
    public static String readUrl(String urlString) throws IOException {
        BufferedReader reader = null;
        try {
            URLConnection connection = new URL(urlString).openConnection();
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.connect();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName(ENCODING)));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    /**
     * Convert satoshis unit to bitcoin units
     * @param satoshisValue
     * @return
     */
    public static Double convertSatoshisToBitcoin(Double satoshisValue) {
        Double bitcoinAmount = satoshisValue / SATOSHIS;

        return bitcoinAmount;
    }
}
