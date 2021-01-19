package com.momoko;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by momoko on 2021/1/18.
 */
public class InetAddressTest {

    public static void main(String args[]) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.43.105");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);

            //获取本机的ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}