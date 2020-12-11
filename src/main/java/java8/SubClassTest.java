package java8;

/**
 * Created by momoko on 2020/12/11.
 */
public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.method2();
        s.method3();

    }
}
class SubClass implements CompareA {

    @Override
    public void method2() {
        System.out.println("subcalss 中的method");
        CompareA.super.method2();
    }
}