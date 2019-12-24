package thread;

/**
 * Created by momoko on 2019/12/24
 *
 * @author momoko
 */

/**
 * 由于Java的线程锁是可重入锁，所以，获取锁的时候，不但要判断是否是第一次获取，还要记录这是第几次获取。
 * 每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁。
 */
public class DuplicateLock {
    private int count;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    private synchronized void  dec(int i) {
        count += i;
    }


}
