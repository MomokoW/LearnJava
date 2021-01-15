package com.momoko;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by momoko on 2021/1/13.
 */
public class GenericTest {

    @Test
    public void test1() {

        ArrayList list = new ArrayList();
        list.add(78);
        list.add(76);

        //问题1：类型不安全
        for (Object score : list) {
            //问题2：强转时，可能出现ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);
        }

    }

    @Test
    public void test2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Jerry", 89);
        map.put("Rose", 99);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + ": " + value);
        }
    }

    @Test
    public void test3() {
        Order order = new Order();
        order.setOrderT(new Object());
    }




}