package com.momoko.learnreg;

/**
 * Created by momoko on 2019/12/13
 *
 * @author momoko
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个字符串表示的数字，判断该数字末尾0的个数。例如：
 * "123000"：3个0
 * "10100"：2个0
 * "1001"：0个0
 */
public class NonGreedyMatch {
    public static void main(String[] args) {
        //正则表达式匹配默认使用贪婪匹配，可以使用?表示对某一规则进行非贪婪匹配。

        Pattern p = Pattern.compile("(\\d+?)(0*)");
        Matcher m = p.matcher("1230000");
        if(m.matches()) {
            System.out.println("group1=" + m.group(1));
            System.out.println("group2=" + m.group(2));

        } else {
            System.out.println("匹配失败!");
        }

    }
}
