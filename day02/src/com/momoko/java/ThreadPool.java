package com.momoko.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by momoko on 2020/12/16.
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
        service1.setMaximumPoolSize(9);
        //2.执行指定的线程的操作，需要提供实现Runnable或Callable接口的类
        service.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            }
        });
        service.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        //3.关闭连接池
        service.shutdown();
    }
}