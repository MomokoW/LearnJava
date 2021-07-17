package com.momoko.juc;

/**
 * Created by momoko on 2021/7/7.
 * 两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加 1，一个线程对该变量减 1
 * 实现交替，来10轮，变量初始值为零。
 */
public class ProducerConsumerDemo {
    private static int index = 1;
    private static volatile boolean f = true;
    public static void main(String[] args) {
        new Thread(() -> {
            while (index <= 26) {
                if (f) {
                    System.out.println(index++);
                    f = false;
                }
            }
        }, "A").start();

        new Thread(() -> {
            while (index <= 27) {
                if (!f) {
                    System.out.println((char)('a'+index-2));
                    f = true;
                    if(index==27)break;
                }
            }
        }, "B").start();

    }

}
