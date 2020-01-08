package java8lambda;

/**
 * Created by sunyuqing on 2019/11/7.
 */
@FunctionalInterface
public interface MyTest {
    String[] test(String str);

    default void test2() {
        System.out.println("test");
    }
    String toString();
}
