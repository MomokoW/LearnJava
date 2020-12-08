package javabasic.day08;

/**
 * Created by momoko on 2020/11/9.
 */
public class OverLoadTest {
    public static void main(String[] args) {
        OverLoadTest test = new OverLoadTest();
        test.mOL(2);
        test.mOL(3,4);
        test.mOL("test");

        System.out.println(test.max(1, 2));
        System.out.println(test.max(5.44, 7.88));
        System.out.println(test.max(4.88, 3.66, 6.73));

    }
    public void mOL(int a) {
        System.out.println(a * a);
    }

    public void mOL(int a, int b) {
        System.out.println(a * b);
    }

    public void mOL(String s) {
        System.out.println(s);
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public double max(double a, double b) {
        return a > b ? a : b;
    }

    public double max(double a, double b, double c) {
        double max = a > b ? a : b;
        return max > c ? max : c;
    }
}