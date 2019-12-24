package thread;

import java.util.concurrent.locks.Lock;

/**
 * Created by momoko on 2019/12/24
 *
 * @author momoko
 */

/**
 * ReentrantLock可以替代synchronized进行同步；
 *
 * ReentrantLock获取锁更安全；
 *
 * 必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁；
 *
 * 可以使用tryLock()尝试获取锁。
 */
public class ReentrantLock {
    private final Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }

    }


}
