package com.momoko.java4;

/**
 * Created by momoko on 2021/1/24.
 */
public class Boy {
    private Girl girl;

    public Boy() {
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}