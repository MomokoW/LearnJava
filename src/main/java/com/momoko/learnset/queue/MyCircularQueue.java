package com.momoko.learnset.queue;

/**
 * Created by sunyuqing on 2019/10/8.
 */
class MyCircularQueue {

    private int[] data;
    private int head,tail;
    private int size,left_size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        tail = -1;
        size = k;
        left_size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        tail = (tail+1)%size;
        data[tail] = value;
        left_size--;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head+1)%size;
        left_size++;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return data[head];

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return left_size == size;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return left_size == 0;
    }
}


