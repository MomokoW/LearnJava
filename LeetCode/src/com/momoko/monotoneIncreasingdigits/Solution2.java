package com.momoko.monotoneIncreasingdigits;

/**
 * Created by momoko on 2020/12/16.
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 官方题解：
 * 解题思路2：贪心算法，从高到低按位构造这个小于等于N的最大单调递增的数字。不考虑N的限制，则对于长度为ｎ的数字
 * 最大单调递增的数字一定是每一位都为９的数字。
 * 记strN[i]表示数字N从高到低的第i位的数字（i从0开始）。
 *
 * 如果整个数字N本身已经是按位单调递增的，那么最大的数字即为N。
 *
 * 如果找到第一个位置i使得[0,i-1]的数位单调递增且strN[i−1]>strN[i]，此时[0,i]的数位都与N的对应数位相等，
 * 仍然被N限制着，即我们不能随意填写[i+1,n−1]位置上的数字。为了得到最大的数字，我们需要解除N的限制，
 * 来让剩余的低位全部变成9，即能得到小于N的最大整数。而从贪心的角度考虑，我们需要尽量让高位与N的对应数位相等，
 * 故尝试让strN[i−1]自身数位减1。此时已经不再受N 的限制，直接将[i,n−1]的位置上的数全部变为9即可。
 *
 * 但这里存在一个问题：当strN[i−1]自身数位减1后可能会使得strN[i−1]和strN[i−2] 不再满足递增的关系，
 * 因此我们需要从i−1开始递减比较相邻数位的关系，直到找到第一个位置j使得strN[j]自身数位减1后strN[j−1]和strN[j]仍然保持递增关系，
 * 或者位置j已经到最左边（即j的值为0），此时我们将[j+1,n−1]的数全部变为9才能得到最终正确的答案。
 *
 * 结果：可行
 *
 */
public class Solution2 {

    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}