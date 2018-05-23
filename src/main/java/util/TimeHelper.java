package util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Convert unix timestamp to Java date object
     *
     * e.g. 1402386611 -> June 10, 2014 7:50:11 AM
     * @param timestamp
     * @return
     */
    public static DateTime convertUnixTimestampToDateTime(Long timestamp) {
        return new DateTime(timestamp * 1000);
    }

    /**
     * Convert Java date object to YYYY-MM-DD format
     * @param datetime
     * @return
     */
    public static String extractDate(DateTime datetime) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_FORMAT);
        String dateStr = fmt.print(datetime);
        return dateStr;
    }

    /**
     * Add numDays to date
     * @param date
     * @param numDays
     * @return
     */
    public static String addDaysToDate(String date, int numDays) {
        DateTime dt = new DateTime(date);
        dt = dt.plusDays(numDays);
        return extractDate(dt);
    }
}
