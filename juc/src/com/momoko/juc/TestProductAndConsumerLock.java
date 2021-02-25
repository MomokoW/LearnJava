package com.momoko.juc;

/**
 * Created by momoko on 2021/2/25.
 * 生产者消费者案例
 * 加上else，当生产者次数变小时，比如最后生产者只需要生产两次，消费者消费一次之后就退出了，而生产者还处于wait状态，无人唤醒，程序就陷入了等待无法结束
 */
public class TestProductAndConsumerLock {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor,"生产者A").start();
        new Thread(consumer,"消费者B").start();
    }
}

//class Clerk {
//    private int product = 0;
//
//    //进货
//    public synchronized void get() {
//        while (product >= 1) {   //为了避免虚假唤醒问题，wait方法应该始终使用在while循环中
//            System.out.println("产品已满");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
////        else {
//            System.out.println(Thread.currentThread().getName() + " : " + ++product);
//            this.notifyAll();
////        }
//    }
//
//    //卖货
//    public synchronized void sale() {
//        while (product <= 0) {
//            System.out.println("缺货");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
////        else {
//            System.out.println(Thread.currentThread().getName() + " : " + --product);
//            this.notifyAll();
////        }
//
//    }
//}
//
//class Productor implements Runnable {
//    private Clerk clerk;
//
//    public Productor(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clerk.get();
//        }
//    }
//}
//
//class Consumer implements Runnable {
//
//    private Clerk clerk;
//    public Consumer (Clerk clerk) {
//        this.clerk = clerk;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            clerk.sale();
//        }
//    }
//}