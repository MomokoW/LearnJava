package java8;

/**
 * Created by momoko on 2020/12/11.
 */
public interface CompareA {
    public static void method1() {
        System.out.println("method1");
    }
    public static void method4() {
        System.out.println("method4");
    }

    default void method2() {
        System.out.println("CompareA");
    }

    public default void method3() {
        System.out.println("CompareA2");
    }
}