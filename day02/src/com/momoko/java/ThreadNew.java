package com.momoko.java;

import java.util.concurrent.Callable;

/**
 * Created by momoko on 2020/12/15.
 * 创建线程的方式三：实现Callable接口 ——JDK5.0新增
 */
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();

    }
}

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}