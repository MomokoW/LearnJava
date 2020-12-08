package com.momoko.before;

/**
 * Created by momoko on 2020/6/23.
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(123, 456);
        int n = add(pair);
        System.out.println(n);

    }
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

}
class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}