package com.momoko.thread;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */

import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic类是通过无锁（lock-free）的方式实现的线程安全（com.momoko.thread-safe）访问。它的主要原理是利用了CAS：Compare and Set
 */
public class LAtomic {

    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
