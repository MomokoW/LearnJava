package com.momoko.encryption;

/**
 * Created by momoko on 2019/12/17
 *
 * @author momoko
 */

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 哈希算法（Hash）又称摘要算法（Digest），它的作用是：对任意一组输入数据进行计算，得到一个固定长度的输出摘要。
 *
 * 哈希算法最重要的特点就是：
 *
 * 相同的输入一定得到相同的输出；
 * 不同的输入大概率得到不同的输出。
 * 哈希算法的目的就是为了验证原始数据是否被篡改。
 */
public class HashAlgorithm {
    public static void main(String[] args) throws Exception {
        //创建一个MessageDigest实例
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //反复调用update输入数据
        md5.update("Hello".getBytes("UTF-8"));
        md5.update("World".getBytes("UTF-8"));
        byte[] result = md5.digest();
        System.out.println(new BigInteger(1, result).toString(16));
    }


}
