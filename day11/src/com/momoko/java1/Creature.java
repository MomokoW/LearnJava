package com.momoko.java1;

import java.io.Serializable;

/**
 * Created by momoko on 2021/1/20.
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}