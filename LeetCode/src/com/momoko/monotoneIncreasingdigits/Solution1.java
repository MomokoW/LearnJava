package com.momoko.monotoneIncreasingdigits;

/**
 * Created by momoko on 2020/12/16.
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 解题思路1：穷举法，从该数开始，依次递减，然后判断该数是否为递增的
 * 结果：可行，但是超出了leetcode的时间限制，穷举法花费时间太多
 *
 *
 */
public class Solution1 {
    public int monotoneIncreasingDigits(int N) {
        //解题思路一：穷举法，从该数开始，依次递减，然后判断是否为单调递增数
        int num = 0;
        for(int i = N; i >= 0; i--) {
            if (isIncrease(i)) {
                num = i;
                break;
            }
        }
        return num;
    }
    public Boolean isIncrease(int N) {
        int[] num = new int[11];
        int k = 0;
        //获取整数每个位上的值，由低到高获取
        while(N > 0) {
            num[k] = N % 10;
            N /= 10;
            k++;
        }
        //依次判断数组是否为递增数组，用递归的方法
        return isIncreaseArr(num, k);
    }
    public Boolean isIncreaseArr(int[] arr,int len) {
        if (len == 1) {
            return true;
        }
        int left = arr[0];
        for (int i = 1; i < len ; i++) {
            int right = arr[i];
            if (left < right) {
                return false;
            } else {
                left = right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num = new Solution1().monotoneIncreasingDigits(963856657);
        System.out.println(num);
    }
}