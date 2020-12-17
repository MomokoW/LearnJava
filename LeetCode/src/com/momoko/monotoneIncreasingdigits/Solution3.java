package com.momoko.monotoneIncreasingdigits;

/**
 * Created by momoko on 2020/12/16.
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * 由于结果要求各位数字单调递增，那么这些数字必然形如 a0a1a2……an (1 <= a0 <= a1 <= a2 <= …… <= an <= 9)、
 * 数字分解成如下（分解式中的n为数字的长度）：
 *        a0 a1 a2 …… an      (1 <= a0 <= a1 <= a2 <= …… <= an <= 9)
 *  =     a0 *  111……1    + (a1 - a0) *   111……1
 *             \-n个1-/                 \-(n-1)个1-/
 *
 *     + (a2 - a1) *   111……1    + ………… + (an - an-1) * 1
 *                   \-(n-2)个1-/
 * 可见最终结果必然是若干个形如 11……11 的数字相加所得。（想到这一点真的太牛了！）
 * 本题中，最大的n为10^9，所以，可以从111111111开始依次累加，如果继续累加将导致结果超过n，
 * 则去掉一个1继续循环。总累加次数不超过9次。
 */

public class Solution3 {
    public int monotoneIncreasingDigits(int N) {
        int ones = 111111111;
        int result = 0;

        for (int i = 0; i < 9; i++) {
            while (result + ones > N) {
                ones /= 10;
            }
            result += ones;
        }
        return result;
    }
}