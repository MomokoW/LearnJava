package com.momoko.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by momoko on 2021/7/6.
 * 三个售票员卖出30张票
 * 1.在高内聚，低耦合的前提下，线程操作资源类
 *     1.1 先创建一个资源类
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.sell();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.sell();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.sell();
            }
        }, "B").start();

    }
}
class Ticket {

    private int num = 30;
    private Lock lock = new ReentrantLock();

    public void sell() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第\t" + (num--) + "张票，还剩\t" + num + "张票");
            } else {
                System.out.println("票卖完啦!");
            }
        } finally {
            lock.unlock();
        }
    }
}
