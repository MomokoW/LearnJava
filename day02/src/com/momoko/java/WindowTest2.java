package com.momoko.java;

/**
 * Created by momoko on 2020/12/15.
 * 解决继承Thread类的线程安全问题
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window2 extends Thread {
    //需要加static才能同步，还有问题
    private static int ticket = 100;

    private static Object obj = new Object();
    @Override
    public void run() {
        while(true) {
//            synchronized (obj) {
            synchronized (Window2.class) {
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}