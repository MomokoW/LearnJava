package com.momoko.java;

/**
 * Created by momoko on 2020/12/15.
 * 解决继承Thread类的线程安全问题
 * 使用同步方法的方式解决线程安全问题
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 extends Thread {
    //需要加static才能同步，还有问题
    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public static synchronized void show() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
            ticket--;
        } else {
            return;
        }
    }
}