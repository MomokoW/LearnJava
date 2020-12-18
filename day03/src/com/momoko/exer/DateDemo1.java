package com.momoko.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by momoko on 2020/12/17.
 * 练习一：字符串“2020-09-08”转换为java.sql.Date
 */
public class DateDemo1 {

    @Test
    public void testDate() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf1.parse(birth);

        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);
    }

    /**
     * 练习二：“三天打鱼两天晒网”  1990-01-01  xxxx-xx-xx 打鱼？晒网？
     * 举例：2020-09-08
     * 提示，计算总天数 % 5 == 1，2，3：打鱼  == 4，0 ：晒网
     *
     * 总天数的计算？
     * 方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24 ) + 1
     * 方式二：1990-01-01  --> 2019-12-31 + 2020-01-01 --> 2020-09-08
     */


    @Test
    public void test1() throws ParseException {
        String date1 = "1990-01-01";
        String date2 = "2020-09-11";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);

        int day = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24 )) + 1;

        switch (day % 5) {
            case 1:
            case 2:
            case 3:
                System.out.println("打鱼");
                break;
            case 0: case 4:
                System.out.println("晒网");
        }


    }
}