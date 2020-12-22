package com.momoko;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by momoko on 2020/12/22.
 */
public class CollectionTest {


    @Test
    public void test1() {
        Collection coll = new ArrayList();

        coll.add("123");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        System.out.println(coll.size());

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}