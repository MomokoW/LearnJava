package momoko.java;

/**
 * Created by momoko on 2020/12/14.
 */
public class StaticTest {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.num);
        A a = new A();
        System.out.println(a.num);
        a.num++;
        System.out.println(b.num);
        System.out.println(A.num);
        b.num++;
        System.out.println(b.num);
        System.out.println(a.num);
    }
}

class A {
    public static int num = 2;
}

class B extends A {
    static int num = 3;
    public void method () {
        System.out.println(num);
    }
}