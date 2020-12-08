package javabasic.day12.exer;

/**
 * Created by momoko on 2020/12/8.
 */
public class InterviewTest {
    public static void main(String[] args) {
        Base1 base = new Sub1();
        base.add(1,2,3);

        Sub1 s = (Sub1) base;
        s.add(1, 2, 3);

        String s1 = "sunny";
        String s2 = "sunny";
        System.out.println(s1.equals(s2));
    }
}

class Base1 {
    public void add(int a, int... arr) {
        System.out.println("base1");
    }
}

class Sub1 extends Base1 {
    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }

    public void add(int a, int b, int c) {
        System.out.println("sub_2");
    }
}