package com.momoko.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by momoko on 2021/1/19.
 */
public class PersonTest {

    @Test
    public void test1() throws Exception {
        //利用反射来获取类内部的信息
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Sunny", 12);
        System.out.println(obj);

        Person p = (Person) obj;

        //通过反射，调用对象指定的方法和属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p, 20);
        System.out.println(p.toString());

    }
}