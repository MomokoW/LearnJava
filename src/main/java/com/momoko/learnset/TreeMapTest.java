package com.momoko.learnset;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 使用TreeMap时，放入的Key必须实现Comparable接口。
 * String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。
 * 作为Value的对象则没有任何要求
 * 如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法
 * TreeMap不使用equals()和hashCode()
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<Person, Integer> map = new TreeMap<>(Comparator.comparing(p -> p.name));
        map.put(new Person("Tom"), 1);
        map.put(new Person("Bob"), 2);
        map.put(new Person("Lily"), 3);
        for (Person key : map.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(map.get(new Person("Bob"))); // 2


        Map<Student,Integer> map2 = new TreeMap<>(Comparator.comparingInt(o -> o.score));
        map2.put(new Student("Tom", 77), 1);
        map2.put(new Student("Bob", 66), 2);
        map2.put(new Student("Lily", 99), 3);

        for(Student key: map2.keySet()) {
            System.out.println(key);
        }

        System.out.println(map2.get(new Student("Bob", 66)));

    }
}
