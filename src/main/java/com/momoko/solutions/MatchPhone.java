package com.momoko.solutions;

import java.util.regex.Pattern;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */
public class MatchPhone {
    public static void main(String[] args) {
        String regex = "(\\+86)?-?1[0-9]{10}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("+8618162778791").matches());
    }
}
