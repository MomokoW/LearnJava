import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by momoko on 2021/6/4.
 */
public class MaxQueueTest {
    public static void main(String[] args) {
//        MaxQueue obj = new MaxQueue();
//        int i = obj.max_value();
//        int i1 = obj.pop_front();
//        int i2 = obj.max_value();
//        obj.push_back(46);
//        int i3 = obj.max_value();
//        int i4 = obj.pop_front();
//        int i5 = obj.max_value();
//        int i6 = obj.pop_front();
//        obj.push_back(868);
//        int i7 = obj.pop_front();
//        int i8 = obj.pop_front();
//        int i9 = obj.pop_front();
//        obj.push_back(525);
//        int i10 = obj.pop_front();
//        int i11 = obj.max_value();
        Integer o1 = 234;
        Integer o2 = 234;
        System.out.println(o1 == o2);

    }

}

class MaxQueue {
    private Queue<Integer> queue;      //主队列
    private Deque<Integer> deque;      //辅助队列

    public MaxQueue(){
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        while(!deque.isEmpty() && value > deque.peekLast()){
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        if(queue.peek().equals(deque.peekFirst())){
            deque.pollFirst();
        }
        return queue.poll();
    }
}
