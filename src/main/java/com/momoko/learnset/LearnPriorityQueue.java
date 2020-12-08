package com.momoko.learnset;

/**
 * Created by momoko on 2019/11/22
 *
 * @author momoko
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关
 * 对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素
 * 要使用PriorityQueue，我们就必须给每个元素定义“优先级”
 * 放入PriorityQueue的元素，必须实现Comparable接口
 * 未实现Comparable接口的对象可提供一个Comparator对象来判断两个元素的顺序
 */
public class LearnPriorityQueue {
    public static void main(String[] args) {

        Queue<User> q = new PriorityQueue<>();
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A112"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
//        Queue<String> q = new PriorityQueue<>();
//        q.offer("apple");
//        q.offer("pear");
//        q.offer("banana");
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
    }

}

class User implements Comparable<User>{
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + "/" +number;
    }

    @Override
    public int compareTo(User o) {
        if (number.charAt(0) == o.number.charAt(0)) {
            Integer num1 = Integer.parseInt(number.substring(1));
            Integer num2 = Integer.parseInt(o.number.substring(1));
            return num1.compareTo(num2);
        }
        if (number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}
