package com.momoko.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by momoko on 2020/12/16.
 * 获取两个字符串中最大相同字串，比如
 * str1 = "abcwerthelloyuiodef"; str2 = "cvhellobnm";
 * 提示：将短的那个串进行长度依次递减的字串与较长的串比较。
 */
public class StringDemo2 {

    @Test
    public void testGetMaxSameString() {
        String str1 = "abcwerthelloyuiodefabcdef";
        String str2 = "cvhellobnmabcdef";
        List<String> results = getMaxSameString(str1, str2);
        for (String result : results) {
            System.out.println(result);
        }
    }

    public List<String> getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            List<String> list = new ArrayList<>();
            String maxStr = str1.length() >= str2.length() ? str1 : str2;
            String minStr = str1.length() < str2.length() ? str1 : str2;

            int length = minStr.length();
            for (int i = 0; i < length; i++) {

                for (int x = 0, y= length - i; y<= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        list.add(subStr);
                    }
                }
                if (list.size() != 0) {
                    break;
                }
            }
            return list;
        }
        return null;
    }
}