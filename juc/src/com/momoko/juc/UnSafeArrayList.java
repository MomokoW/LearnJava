package com.momoko.juc;

import java.util.*;

/**
 * Created by momoko on 2021/7/7.
 */
public class UnSafeArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> safeList = Collections.synchronizedList(list);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                safeList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(safeList);
            }, String.valueOf(i)).start();
        }
    }
}
