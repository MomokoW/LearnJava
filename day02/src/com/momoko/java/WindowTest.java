package com.momoko.java;

/**
 * Created by momoko on 2020/12/14.
 * 问题：卖票过程中出现了重票、错票的问题
 * 原因：当某个线程操作车票的过程中，尚未完成操作吗，其他线程参与进来，也操作车票
 * 如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来，直到线程A操作完ticket，
 *         即使A被阻塞，也不能改变。
 * */
public class WindowTest {
    public static void main(String[] args) {
        Window w = new Window();
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

class Window implements Runnable {
    private int ticket = 100;
    Object a  = new Object();
    @Override
    public void run() {
        while (true) {
//            synchronized(a) {
            synchronized (this) { //此时的this:唯一的window对象
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}