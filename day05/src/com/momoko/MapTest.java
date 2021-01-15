package com.momoko;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by momoko on 2020/12/31.
 */
public class MapTest {

    @Test
    public void test1() {
        HashMap hashMap = new HashMap();
        hashMap.put("123","1234");

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }
        Properties properties = new Properties();

    }
}