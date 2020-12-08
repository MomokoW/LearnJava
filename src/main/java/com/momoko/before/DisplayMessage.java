package com.momoko.before;

/**
 * Created by sunyuqing on 2019/9/19.
 */
public class DisplayMessage implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(message);
        }
    }
}
