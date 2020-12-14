package momoko.java;

/**
 * Created by momoko on 2020/12/14.
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread t = new Thread(myThread2);
        t.start();
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {

    }
}