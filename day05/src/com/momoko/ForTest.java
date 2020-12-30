package com.momoko;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by momoko on 2020/12/30.
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        coll.add("123");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        for (Object o : coll) {
            System.out.println(o);
        }
    }
}