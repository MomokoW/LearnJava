package com.momoko.date_and_time;

/**
 * Created by momoko on 2019/12/5
 *
 * @author momoko
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Calendar可以用于获取并设置年、月、日、时、分、秒，它和Date比，主要多了一个可以做简单的日期和时间运算的功能
 */
public class LearnCalender {
    public static void main(String[] args) {
        //获取当前时间
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1; //0~11
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);

        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);

        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

        /**
         * Calendar只有一种方式获取，即Calendar.getInstance()，而且一获取到就是当前时间。如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段
         */


    }

    public static String getNextDayWeekStr(Date date) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.setTime(date);
        int dayOfWeek = (c.get(Calendar.DAY_OF_WEEK)+1)%7;
        switch (dayOfWeek) {
            case 0:
                return "Sat";
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tus";
            case 4:
                return "Wed";
            case 5:
                return "Four";
            case 6:
                return "Fri";
            default:
                break;
        }
        return "Not Found";
    }

    public void transferTimeZone() {
        /**
         * 利用Calendar进行时区转换的步骤是：
         *
         * 清除所有字段；
         * 设定指定时区；
         * 设定日期和时间；
         * 创建SimpleDateFormat并设定目标时区；
         * 格式化获取的Date对象（注意Date对象无时区信息，时区信息存储在SimpleDateFormat中）。
         */
        Calendar c= Calendar.getInstance();
        c.clear();
        c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        c.set(2019,11,5,16,05,44);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf.format(c.getTime()));
    }
}
