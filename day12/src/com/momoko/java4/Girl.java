package com.momoko.java4;

/**
 * Created by momoko on 2021/1/24.
 */
public class Girl {

    private String name;

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}