package com.momoko.reflcet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by momoko on 2020/6/21.
 */
public class LearnField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object p = new Person("Xiao Ming",26);
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p,"Sunny");
        Object value = f.get(p);

        System.out.println(value); // "Xiao Ming"

        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class,int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6,9);
        // 打印调用结果:
        System.out.println(r);

        //调用静态方法，invoke方法传入的第一个参数永远为null
        Method n = Integer.class.getMethod("parseInt", String.class);
        Integer num = (Integer) n.invoke(null, "123456");
        System.out.println(num);

        //获取构造方法Integer(int)
        Constructor<Integer> cons1 = Integer.class.getConstructor(int.class);

        //调用构造方法
        Integer n1 = cons1.newInstance(123);
        System.out.println(n1);

        // 获取构造方法Integer(String)
        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("456");
        System.out.println(n2);


    }


}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person{
    private String score;

    public Student(String name,int age,String score) {
        super(name,age);
        this.score = score;
    }
}