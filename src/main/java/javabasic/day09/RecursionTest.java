package javabasic.day09;

/**
 * Created by momoko on 2020/11/10.
 */
public class RecursionTest {
    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();
        System.out.println(test.getSum(10));
        System.out.println(test.Fibonacci(6));
    }

    /**
     * f(0) = 1, f(1) = 4, f(n+2) = 2 * f(n+1) + f(n)
     * @param n
     * @return sum
     */
    public int getSum(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 4;
        else
            return 2 * getSum(n - 1) + getSum(n - 2);
    }


    public int Fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}