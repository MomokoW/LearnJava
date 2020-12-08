package com.momoko.thread;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */

/**
 * 一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：
 *
 * get()：获取结果（可能会等待）
 * get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
 * cancel(boolean mayInterruptIfRunning)：取消当前任务；
 * isDone()：判断任务是否已完成。
 */
public class LFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<?> future = es.submit(new Task("601857"));
        System.out.println(future.get());
        es.shutdown();
    }

}
class Task1 implements Callable<BigDecimal> {

    public Task1(String code) {
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(1000);
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
    }
}
