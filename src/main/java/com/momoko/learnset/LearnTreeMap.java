package com.momoko.learnset;

/**
 * Created by momoko on 2019/11/21
 *
 * @author momoko
 */

class Person {
    public String name;

    Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "{Person: " + name + "}";
    }

}

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{%s: score=%d}",name,score);
    }
}
