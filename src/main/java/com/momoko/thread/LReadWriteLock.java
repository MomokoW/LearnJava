package com.momoko.thread;

/**
 * Created by momoko on 2019/12/24
 *
 * @author momoko
 */

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReadWriteLock可以解决这个问题，它保证：
 *
 * 只允许一个线程写入（其他线程既不能写入也不能读取）；
 * 没有写入时，多个线程允许同时读（提高性能）。
 */
public class LReadWriteLock {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }

}
