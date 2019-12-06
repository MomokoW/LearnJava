package test;

/**
 * Created by momoko on 2019/12/6
 *
 * @author momoko
 */
public class Calculator {
    private long n = 0;

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }
    public long div(long x) {
        n = n/x;
        return n;
    }
}
