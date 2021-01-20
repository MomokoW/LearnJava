package com.momoko.java1;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by momoko on 2021/1/20.
 */
public class PersonTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(modifiers + "\t");

            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            System.out.println(f.getName());

        }

    }
    /*
    获取运行时类带泛型的父类的泛型
     */

    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
    }

    /*
    获取运行时类的接口
     */
    @Test
    public void test4() {
        Class<Person> personClass = Person.class;
        Class[] interfaces = personClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }
}