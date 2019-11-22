package learnset;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by momoko on 2019/11/22
 *
 * @author momoko
 */

/**
 * Deque实现了一个双端队列（Double Ended Queue），它可以：
 *
 * 将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
 * 从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
 * 从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
 * 总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
 * 避免把null添加到队列。
 */
public class LearnDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A");
        deque.offerLast("B");
        deque.offerFirst("C");
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
    }
}
