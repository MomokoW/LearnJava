package com.momoko.learnreg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by momoko on 2019/12/13
 *
 * @author momoko
 */
public class UseRegex {
    public static void main(String[] args) {
        //分割字符串

        String[] s1 = "a b c".split("\\s");
        String[] s2 = "a b  c  d".split("\\s");
        String[] s3 = "a, b ;; c".split("[,;\\s+]");
        for (String s : s2) {
            System.out.println(s);
        }


        //搜索字符串
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(),m.end());
            System.out.println(sub);
        }

        //替换字符串
        s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog.

        //反向引用
        s = "the quick brown fox jumps over the lazy dog.";
        String result = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(result);


    }
}
