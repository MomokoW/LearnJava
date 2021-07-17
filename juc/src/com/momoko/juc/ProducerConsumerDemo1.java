package com.momoko.juc;

/**
 * Created by momoko on 2021/7/7.
 * 两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加 1，一个线程对该变量减 1
 * 实现交替，来10轮，变量初始值为零。
 */
public class ProducerConsumerDemo1 {
    public static void main(String[] args) {
        Aircondition air = new Aircondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    air.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    air.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}

class Aircondition {
    private int number = 0;

    public synchronized void increment() throws Exception {
        // 1.判断
        if (number != 0) {
            this.wait();
        }
        // 2.干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 3.通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        if (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}

