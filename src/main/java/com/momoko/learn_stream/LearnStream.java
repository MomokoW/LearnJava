package com.momoko.learn_stream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by momoko on 2020/6/24.
 */
public class LearnStream {
    public static void main(String[] args) {
        /**
         * 使用Stream.of()创建一个Stream
         */
        Stream<String> stream = Stream.of("A", "B", "C", "D", "E");
        stream.forEach(System.out::println);

        /**
         * 基于一个数组或者Collection，这样该Stream输出的元素就是数组或者Collection持有的元素：
         */
        Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);

        /**
         * 创建Stream还可以通过Stream.generate()方法，它需要传入一个Supplier对象
         * 基于Supplier创建的Stream会不断调用Supplier.get()方法来不断产生下一个元素，这种Stream保存的不是元素，而是算法，它可以用来表示无限序列。
         */
        Stream<Integer> stream3 = Stream.generate(new NaturalSupplier());
        stream3.limit(20).forEach(System.out::println);

        //编写一个能输出斐波那契数列的LongStream
        Stream<Long> stream4 = Stream.generate(new FibonacciSupplier());
        stream4.limit(10).forEach(System.out::println);

        String[] array = new String[] { " 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
                " 2025-01 -01" };
        // 请使用map把String[]转换为LocalDate并打印:
        Stream<String> stream5 = Arrays.stream(array);
        stream5.map(s -> s.replaceAll("\\s+", ""))
                .map(s->LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .forEach(System.out::println);

        List<Person> persons = List.of(new Person("小明", 88), new Person("小黑", 62), new Person("小白", 45),
                new Person("小黄", 78), new Person("小红", 99), new Person("小林", 58));
        // 请使用filter过滤出及格的同学，然后打印名字:
        persons.stream()
        .filter(person -> person.score >= 60)
        .forEach(p->System.out.println(p.name));

        // 按行读取配置文件:
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Map.of(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
    }


class Person {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class NaturalSupplier implements Supplier<Integer> {
    int n = 0;
    @Override
    public Integer get() {
        n++;
        return n;
    }
}

class FibonacciSupplier implements Supplier<Long> {

    long a = 0;
    long b = 1;

    @Override
    public Long get() {
        long c = a + b;
        a = b;
        b = c;
        return a;
    }
}