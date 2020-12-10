package javabasic.day13;

/**
 * Created by momoko on 2020/12/9.
 */

import org.junit.Test;

/**
 * 创建JAVA类进行单元测试
 * 刺激JAVA类要求：
 * 1.此类是public的
 * 2.此类提供公共的无参的构造器
 * 单元测试方法权限是public且没有返回值类型，没有形参
 * 此单元测试方法上需要声明注解，@Test
 *
 */

public class JUnitTest {

    @Test
    public void testEquals() {
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
    }

    @Test
    public void test1() {
        int num1 = 12;
        System.out.println((double) num1);
        //可能会报NumberFormatException
        int num3 = Integer.parseInt("123");

    }

    @Test
    public void test2() {
        //会进行自动类型提升
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);
    }

    @Test
    public void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);

        /**
         * 使用了IntegerCache结构，IntegerCache中定义了Integer[]
         * 保存了从-128~127范围的整数。如果我们使用自动装箱的方式，
         * 给Integer赋值的范围在-128~127范围内时，可以直接使用数组中的元素，不用再去new了。
         * 目的：提高效率
         */

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);
    }

}