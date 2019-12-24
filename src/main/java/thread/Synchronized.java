package thread;

/**
 * Created by momoko on 2019/12/24
 *
 * @author momoko
 */

/**
 * 使用synchronized：
 *
 * 找出修改共享变量的线程代码块；
 * 选择一个共享实例作为锁；
 * 使用synchronized(lockObject) { ... }。
 */
public class Synchronized {
    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        DecThread decThread = new DecThread();
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
             synchronized (Counter.lock) {
                 Counter.count -= 1;
             }
        }
    }
}
