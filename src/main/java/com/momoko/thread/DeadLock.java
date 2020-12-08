package com.momoko.thread;

/**
 * Created by momoko on 2019/12/24
 *
 * @author momoko
 */

/**
 * 避免死锁的方法是多线程获取锁的顺序要一致。
 */
public class DeadLock {
    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        System.out.println("Main Thread");
    }

    static void sleep1s() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {

    public void run() {
        System.out.println("Thread-1: try get lock A...");
        synchronized (DeadLock.LOCK_A) {
            System.out.println("Thread-1: lock A got.");
            DeadLock.sleep1s();
            System.out.println("Thread-1: try get lock B...");
            synchronized (DeadLock.LOCK_B) {
                System.out.println("Thread-1: lock B got.");
                DeadLock.sleep1s();
            }
            System.out.println("Thread-1: lock B released.");
        }
        System.out.println("Thread-1: lock A released.");
    }
}

class Thread2 extends Thread {

    public void run() {
        System.out.println("Thread-2: try get lock A...");
        synchronized (DeadLock.LOCK_A) {
            System.out.println("Thread-2: lock A got.");
            DeadLock.sleep1s();
            System.out.println("Thread-2: try get lock B...");
            synchronized (DeadLock.LOCK_B) {
                System.out.println("Thread-2: lock B got.");
                DeadLock.sleep1s();
            }
            System.out.println("Thread-2: lock B released.");
        }
        System.out.println("Thread-2: lock A released.");
    }
}
