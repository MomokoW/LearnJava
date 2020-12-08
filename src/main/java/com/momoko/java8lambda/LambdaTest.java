package com.momoko.java8lambda;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Created by sunyuqing on 2019/11/7.
 */
public class LambdaTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Jframe");
        JButton jButton = new JButton("My Button");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int jFrameWidth = 100;
        int jFrameHeight = 100;
        jFrame.setBounds(
                (screenSize.width - jFrameWidth) / 2, (screenSize.height - jFrameHeight) / 2, jFrameWidth, jFrameHeight);
        jFrame.add(jButton);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jButton.addActionListener((w) -> System.out.println("Action performed"));

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action performed");
                e.getActionCommand();
            }
        });
        jButton.addActionListener(w-> {
                System.out.println("Action performed");
                w.getActionCommand();
            });

        /**
         * Java Lambda 标准写法：
         * (param1, param2) -> {expression};
         *
         * 如果参数只有一个，小括号可以去掉：
         * param -> {expression};
         *
         * 如果表达式只有一行，大括号，可以去掉，并且这一行最后的分号结尾，要去掉
         *
         */


        // Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // doSomething
                System.out.println("com/momoko/test");
            }
        }).start();

        new Thread(() -> System.out.println("com/momoko/test")).start();

        class MyRunnable implements Runnable {

            @Override
            public void run() {

            }
        }
    }
}
