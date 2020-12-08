package com.momoko.date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by momoko on 2019/12/5
 *
 * @author momoko
 */
public class LearnLocalDateTime {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();   //当前日期
        LocalTime t = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();

        //LocalDateTime、LocalDate和LocalTime默认严格按照ISO 8601规定的日期和时间格式进行打印
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);

        LocalDate d2 = LocalDate.of(2019, 12, 5);
        LocalTime t2 = LocalTime.of(17, 0, 0);
        LocalDateTime dt2 = LocalDateTime.of(d2, t2);
        System.out.println(dt2);


        /*
          注意ISO 8601规定的日期和时间分隔符是T。标准格式如下：

          日期：yyyy-MM-dd
          时间：HH:mm:ss
          带毫秒的时间：HH:mm:ss.SSS
          日期和时间：yyyy-MM-dd'T'HH:mm:ss
          带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS
         */

        LocalDateTime dt3 = LocalDateTime.parse("2019-11-19T15:16:17");
        System.out.println(dt3);


        //自定义输出格式，使用DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        //用自定义格式解析：
        LocalDateTime dt4 = LocalDateTime.parse("2019/12/05 15:16:17",dtf);
        System.out.println(dt4);


        //链式加减
        LocalDateTime dt5 = dt4.plusDays(1).minusHours(3).plusDays(2);
        System.out.println(dt5);

        /*
          对日期和时间进行调整则使用withXxx()方法

          调整年：withYear()
          调整月：withMonth()
          调整日：withDayOfMonth()
          调整时：withHour()
          调整分：withMinute()
          调整秒：withSecond()
         */
        LocalDateTime dt6 = dt4.withDayOfMonth(31);
        System.out.println(dt6);

        //调整月份时，会相应地调整日期
        LocalDateTime dt7 = dt6.withMonth(9);
        System.out.println(dt7);


        //本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        //本月最后一天
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        //下月第一天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(lastDay);

        //本月第一个工作日:
        LocalDate firstWeekDay = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekDay);

        //要判断两个LocalDateTime的先后，可以使用isBefore()、isAfter()方法，对于LocalDate和LocalTime类似：
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        System.out.println(now.isBefore(target));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));

        //Duration表示两个时刻之间的时间间隔。另一个类似的Period表示两个日期之间的天数
        LocalDateTime oneTime = LocalDateTime.of(2019, 12, 6, 11, 22, 33);
        LocalDateTime seconTime = LocalDateTime.of(2019, 12, 8, 11, 44, 55);
        Duration duration = Duration.between(oneTime, seconTime);
        System.out.println(duration);
        Period until = LocalDate.of(2019, 11, 29).until(LocalDate.of(2019, 12, 6));
        System.out.println(until);

        Duration duration1 = Duration.ofHours(10); // 10 hours
        Duration duration2 = Duration.parse("P1DT2H3M"); // 1 day, 2 hours, 3 minutes


    }
}
