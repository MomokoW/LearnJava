package com.momoko.java;

import static java.lang.Thread.*;

/**
 * Created by momoko on 2020/12/15.
 * 解决继承Thread类的线程安全问题
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    //需要加static才能同步，还有问题
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() { //同步监视器：this
        if (ticket > 0) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(currentThread().getName() + ":卖票，票号为:" + ticket);
            ticket--;
        }
    }
}