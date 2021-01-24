package com.momoko.java1;

import org.junit.Test;

/**
 * Created by momoko on 2021/1/23.
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个Runnable");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("这又是一个Runnable ");
        r2.run();
    }



}