package learnset.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyuqing on 2019/10/8.
 */
public class Queue {
    private List<Integer> data;
    private int p_start;

    public Queue() {
        data = new ArrayList<>();
        p_start = 0;
    }

    /**
     * Insert an element into the queue. Return true if the operation is successful.
     */

    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        data.remove(p_start++);
        return true;
    }

    /**
     *  Get the front item from the queue.
     */
    public int Front() {
        return data.get(p_start);
    }

    /**
     * Checks whether the queue is empty or not.
     */
    private boolean isEmpty() {
        return p_start>=data.size();
    }

}
