package com.momoko;

/**
 * Created by momoko on 2021/6/3.
 */
public class JVMTest {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();  // 返回Java虚拟机试图使用的最大内存量
        long totalMemory = Runtime.getRuntime().totalMemory();  // 返回Java虚拟机中的内存总量
        System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
    }
}