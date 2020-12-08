package com.momoko.l_annotation;

import java.lang.reflect.Field;

/**
 * Created by momoko on 2020/6/21.
 */
public class Person {

    @Range(min = 1, max = 4)
    public String name;

    @Range(max = 3)
    public String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    void check(Person person) throws IllegalAccessException {
        for (Field field : person.getClass().getFields()) {
            //获取field定义的@Range
            Range range = field.getAnnotation(Range.class);
            //如果@Range存在
            if(range != null) {
                Object value = field.get(person);
                if(value instanceof String) {
                    String s = (String) value;
                    if(s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person p = new Person("Bob Karson", "1111");
        p.check(p);

    }

}