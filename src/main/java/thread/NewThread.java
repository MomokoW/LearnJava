package thread;

/**
 * Created by momoko on 2019/12/20
 *
 * @author momoko
 */
public class NewThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        //要特别注意：直接调用Thread实例的run()方法是无效的：
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束

        System.out.println("end");
        //方法二：创建Thread实例时，传入一个Runnable实例：
        Thread thread = new Thread(() -> System.out.println("Start a new Thread"));
        thread.start();

        Thread t1 = new Thread(()-> System.out.println("hello"));
        t1.start();
        try {
            //当main线程对线程对象t调用join()方法时，主线程将等待变量t表示的线程运行结束，即join就是指等待该线程结束，然后才继续往下执行自身线程。
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");

    }
}


/**
 * Java线程的状态有以下几种：
 *
 * New：新创建的线程，尚未执行；
 * Runnable：运行中的线程，正在执行run()方法的Java代码；
 * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
 * Waiting：运行中的线程，因为某些操作在等待中；
 * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
 * Terminated：线程已终止，因为run()方法执行完毕。
 *
 * 用一个状态转移图表示如下：
 *
 *          ┌─────────────┐
 *          │     New     │
 *          └─────────────┘
 *                 │
 *                 ▼
 * ┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐
 *  ┌─────────────┐ ┌─────────────┐
 * ││  Runnable   │ │   Blocked   ││
 *  └─────────────┘ └─────────────┘
 * │┌─────────────┐ ┌─────────────┐│
 *  │   Waiting   │ │Timed Waiting│
 * │└─────────────┘ └─────────────┘│
 *  ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─
 *                 │
 *                 ▼
 *          ┌─────────────┐
 *          │ Terminated  │
 *          └─────────────┘
 */


//方法一：从Thread派生一个自定义类，然后覆写run()方法：
class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while(!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }

    }
}








