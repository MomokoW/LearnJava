package javabasic.day16;

/**
 * Created by momoko on 2020/12/12.
 */
public class MyException  extends RuntimeException {
    static final long serialVersionUID = -9223365651560458532L;

    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }
}