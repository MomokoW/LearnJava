package com.momoko.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by momoko on 2019/12/24
 *
 * @author momoko
 */
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//            System.out.println(String.format("Thread %d start", i));
            Thread t = new Thread(() -> {
                // 执行task:
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }
    }


}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();   // 唤醒在this锁等待的线程
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            // 释放this锁:
            this.wait();
            // 重新获取this锁
        }
        return queue.remove();
    }
}
