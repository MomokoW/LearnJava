package com.momoko.java;

/**
 * Created by momoko on 2020/12/15.
 * 生产者消费者问题
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);

        t1.setName("生产者");
        t2.setName("消费者");

        t1.start();
        t2.start();
    }
}

class Clerk {
    private int productCount = 0;
    public synchronized void produceProduct() {
        if (productCount < 20) {
            ++productCount;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品...");
        while (true) {
            clerk.produceProduct();
        }

    }
}
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始消费产品...");
        while (true) {
            clerk.consumeProduct();
        }
    }
}