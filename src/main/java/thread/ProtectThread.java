package thread;

/**
 * Created by momoko on 2019/12/20
 *
 * @author momoko
 */

/**
 * 守护线程是为其他线程服务的线程；
 *
 * 所有非守护线程都执行完毕后，虚拟机退出；
 *
 * 守护线程不能持有需要关闭的资源（如打开文件等）。
 * 创建守护线程，在调用start前调用setDaemon(true)把该线程设置为守护线程
 */
public class ProtectThread {
    public static void main(String[] args) {
        Thread t = new Thread1();
        // 如果注释下一行，观察Thread1的执行情况:
//        t.setDaemon(true);
        t.start();
        System.out.println("main: wait 3 sec...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("main: end.");
    }

}

class Thread1 extends Thread {

    public void run() {
        int n = 0;
        for (;;) {
            n++;
            System.out.println(String.format("Thread-1: running %d times",n));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
