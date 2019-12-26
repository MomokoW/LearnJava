package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */

/**
 * 因为ExecutorService只是接口，Java标准库提供的几个常用实现类有：
 *
 * FixedThreadPool：线程数固定的线程池；
 * CachedThreadPool：线程数根据任务动态调整的线程池；
 * SingleThreadExecutor：仅单线程执行的线程池。
 */
public class ThreadPool {
    public static void main(String[] args) {
        //创建一个固定大小的线程池
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task(""+i));
        }
        es.shutdown();


        //放入ScheduledThreadPool的任务可以定期反复执行
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);

        //1秒后执行一次任务
        ses.schedule(new Task("One time"),1, TimeUnit.SECONDS);

        // 2秒后开始执行定时任务，每3秒执行:
        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);

        // 3秒后开始执行定时任务，以3秒为间隔执行:
        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
        /*
        注意FixedRate和FixedDelay的区别。FixedRate是指任务总是以固定时间间隔触发，不管任务执行多长时间：

         │░░░░   │░░░░░░ │░░░    │░░░░░  │░░░
         ├───────┼───────┼───────┼───────┼────>
         │<─────>│<─────>│<─────>│<─────>│
         而FixedDelay是指，上一次任务执行完毕后，等待固定的时间间隔，再执行下一次任务：

         │░░░│       │░░░░░│       │░░│       │░
         └───┼───────┼─────┼───────┼──┼───────┼──>
             │<─────>│     │<─────>│  │<─────>│
         */


    }

}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run () {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println("end task " + name);
    }
}
