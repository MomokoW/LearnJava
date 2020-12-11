package com.momoko.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by sunyuqing on 2019/11/7.
 */
public class AppleService {
    static List<Apple> appleStore = new ArrayList<>();

    static {
        appleStore.add(new Apple("red", 500, 1));
        appleStore.add(new Apple("yellow", 400, 2));
        appleStore.add(new Apple("green", 300, 3));
        appleStore.add(new Apple("red", 500, 3));
        appleStore.add(new Apple("yellow", 600, 2));
        appleStore.add(new Apple("green", 500, 2));
        appleStore.add(new Apple("red", 500, 1));
        appleStore.add(new Apple("yellow", 400, 1));
        appleStore.add(new Apple("green", 500, 3));
        appleStore.add(new Apple("red", 400, 1));
    }


    public static List<Apple> getRedApples() {
        List<Apple> redApples = new ArrayList<>();
        for (Apple apple : appleStore) {
            if (apple.getColor().equals("red"))
                redApples.add(apple);
        }
        return redApples;
    }

    public static void forEachAndThen(Consumer<Apple> consumer) {
        for (Apple apple : appleStore) {
            consumer.andThen(apple1 -> {
                if (apple1.getWeight() >= 500) {
                    System.out.println(apple1);
                }
            }).accept(apple);
        }
    }


    public static void main(String[] args) {
//        for (Apple redApple : getRedApples()) {
//            System.out.println(redApple);
//        }


//        appleStore.forEach(new Consumer<Apple>() {
//            @Override
//            public void accept(Apple apple) {
//                if (apple.getColor().equals("green")) {
//                    System.out.println(apple);
//                }
//            }
//        });

//        System.out.println("====================");
//        appleStore.forEach(apple -> {
//            if (apple.getColor().equals("green")) {
//                System.out.println(apple);
//            }
//        });

        // 如果我们只是想遍历所有的 apple，并打印应该怎么做？
        appleStore.forEach(new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println(apple);
            }
        });
        // Replace with method reference
        appleStore.forEach(System.out::println);

        /**
         * 如果，lambda 表达式只有一个参数，表达式只有一行
         * 且表达式调用了这个的参数本身，那么这个参数可以省略
         * 并且变成方法引用的形式：
         *
         * 对象调用方法
         *
         * 对象::方法名
         *
         * 当表达式为前述参数只调用一次自己的方法，也可以变为方法引用
         *
         * 参数类名::方法名
         */


        // Stream 操作

        // for 循环
        for (int i = 0; i < appleStore.size(); i++) {

        }

        for (Apple apple : appleStore) {

        }

        appleStore.forEach(apple -> {
        });

        //
        AppleService appleService = new AppleService();
        int redPriceSum = appleStore.stream()
                .filter(apple -> apple.getColor().equals("red"))
                .mapToInt(Apple::getPrice).sum();
        System.out.println(redPriceSum);

        Stream.of(1, 2, 3, 4, 5, 6).filter(i->i%2!=0).forEach(System.out::println);

    }

    public void print(Apple apple) {
        System.out.println(apple);
    }
}
