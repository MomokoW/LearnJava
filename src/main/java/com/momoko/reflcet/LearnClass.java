package com.momoko.reflcet;

import com.momoko.before.Employee;

/**
 * Created by momoko on 2020/6/21.
 */
public class LearnClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //通过Class实例获取class信息的方式称为反射

        //方法一：直接通过一个class的静态变量class获取：
        Class cls = String.class;
        printClassInfo(cls);

        //方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
        Employee e = new Employee();
        Class cls1 = e.getClass();
        printClassInfo(cls1);

        //方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls2 = Class.forName("com.momoko.before.LearnLogger");
        printClassInfo(cls2);

        //如果获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：
        // 创建一个String实例:
        String s = (String) cls.newInstance();
        //上述代码相当于new String()。通过Class.newInstance()可以创建类实例，它的局限是：只能调用public的无参数构造方法。带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。

    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("Is interface: " + cls.isInterface());
        System.out.println("Is enum: " + cls.isEnum());
        System.out.println("Is array: " + cls.isArray());
        System.out.println("Is primitive: " + cls.isPrimitive());

    }
}