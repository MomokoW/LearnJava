package com.momoko.thread;

/**
 * Created by momoko on 2019/12/20
 *
 * @author momoko
 */
public class InterruptTread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(1600);
        t.interrupt(); // 中断t线程

        //如果在t线程处于等待状态时调用interrupt让线程中断会抛出异常
        t.join(); // 等待t线程结束
        System.out.println("end");

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        Thread.sleep(1);
        myThread2.running = false;

    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();   // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }

        hello.interrupt();

    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                break;
            }
        }
    }
}

/**
 * 另一个常用的中断线程的方法是设置标志位。
 * 我们通常会用一个running标志位来标识线程是否应该继续运行
 * 通过标志位判断需要正确使用volatile关键字；
 *
 * volatile关键字解决了共享变量在线程间的可见性问题
 */
class MyThread2 extends Thread {
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}
