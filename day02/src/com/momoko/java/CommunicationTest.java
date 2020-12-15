package com.momoko.java;

/**
 * Created by momoko on 2020/12/15.
 * 使用两个线程打印1-100，交替打印
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
//        n1.test();

    }
}
class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait(); //调用wait的线程会进入阻塞状态且会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }

    }

    public void test()  {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}