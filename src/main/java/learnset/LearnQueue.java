package learnset;

/**
 * Created by momoko on 2019/11/22
 *
 * @author momoko
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列Queue实现了一个先进先出（FIFO）的数据结构
 *
 * int size()：获取队列长度；
 * boolean add(E)/boolean offer(E)：添加元素到队尾；
 * E remove()/E poll()：获取队首元素并从队列中删除；
 * E element()/E peek()：获取队首元素但并不从队列中删除。
 * 要避免把null添加到队列.
 */
public class LearnQueue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        if(q.offer("apple"))
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
        q.offer("banana");
        q.offer("orange");
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
