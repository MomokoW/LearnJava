package date_and_time;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * DateTimeFormatter是线程安全的
 * DateTimeFormatter可以只创建一个实例，到处引用。
 */
public class LearnDateTimeFormatter {
    public static void main(String[] args) {
        //传入格式化字符串来创建
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZZ!");
        //传入格式化字符串时，同时指定Locale
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, yyyy-MM-dd", Locale.US);

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(dateTimeFormatter.format(zdt));
        System.out.println(formatter.format(zdt));


    }
}
