package com.momoko.learnset;

/**
 * Created by momoko on 2019/11/21
 *
 * @author momoko
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Set用于存储不重复的元素集合，它主要提供以下几个方法：
 * <p>
 * 将元素添加进Set<E>：boolean add(E e)
 * 将元素从Set<E>删除：boolean remove(Object e)
 * 判断是否包含元素：boolean contains(Object e)
 *
 * 因为放入Set的元素和Map的key类似，都要正确实现equals()和hashCode()方法，否则该元素无法正确地放入Set。
 */
public class LearnSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.size());
        List<String> items = set.stream().filter(s -> s.equals("xyz")).collect(Collectors.toList());
        System.out.println(items);
    }


}
