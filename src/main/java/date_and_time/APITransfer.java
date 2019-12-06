package date_and_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */
public class APITransfer {
    public static void main(String[] args) {
        //旧API转新API
        Instant ins = new Date().toInstant();

        //Calender -> Instant -> ZonedDateTime
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = Calendar.getInstance().toInstant();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());

        //新API转旧API，只能通过long来转
        //ZonedDateTime -> long:
        ZonedDateTime zdt1 = ZonedDateTime.now();
        long second = zdt1.toEpochSecond() * 1000;

        //long -> Date
        Date date = new Date(second);

        //long -> Calendar
        Calendar c = Calendar.getInstance();
        c.clear();
        c.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
        c.setTimeInMillis(second);
    }



    //为不同用户以不同的偏好来显示不同的本地时间
    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(instant, ZoneId.of(zoneId)));
    }
}
