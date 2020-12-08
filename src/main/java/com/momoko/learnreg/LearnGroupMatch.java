package com.momoko.learnreg;

/**
 * Created by momoko on 2019/12/13
 *
 * @author momoko
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 利用分组按括号提取子串
 */
public class LearnGroupMatch {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})-(\\d{7,8})");
        Matcher m = p.matcher("027-8788048");
        if(m.matches()) {
            //group参数的0提取整个串，1提取第一个子串，以此类推
            String s1= m.group(1);
            String s2 = m.group(2);
            System.out.println(s1);
            System.out.println(s2);
        } else {
            System.out.println("匹配失败!");
        }
        //使用Matcher时，必须首先调用matches()判断是否匹配成功，匹配成功后，才能调用group()提取子串

        //利用分组匹配，从字符串"23:01:59"提取时、分、秒。
        Pattern pattern = Pattern.compile("([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
        Matcher matcher = pattern.matcher("23:01:59");
        if(matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        } else {
            System.out.println("匹配失败!");
        }
    }



}
