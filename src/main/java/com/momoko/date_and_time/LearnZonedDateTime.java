package com.momoko.date_and_time;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 表示带时区的日期和时间
 * 可以简单地把ZonedDateTime理解成LocalDateTime加ZoneId
 */
public class LearnZonedDateTime {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();   //默认时区
        System.out.println(zbj);
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));//指定时区
        System.out.println(zny);

        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime zsh = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zzjg = ldt.atZone(ZoneId.of("America/Chicago"));
        System.out.println(zsh);
        System.out.println(zzjg);


        //时区转换
        /*
        要转换时区，首先我们需要有一个ZonedDateTime对象，
        然后，通过withZoneSameInstant()将关联时区转换到另一个时区，
        转换后日期和时间都会相应调整
         */
        ZonedDateTime zbj1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        //转换为纽约时间
        ZonedDateTime zny1 = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj1);
        System.out.println(zny1);


        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // com.momoko.test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        LocalDateTime arriveTime = bj.plusHours(h).plusMinutes(m);
        ZonedDateTime zbj = ZonedDateTime.of(arriveTime, ZoneId.of("Asia/Shanghai"));
        //转换为纽约时间
        bj = zbj.withZoneSameInstant(ZoneId.of("America/New_York")).toLocalDateTime();
        return bj;
    }


}


