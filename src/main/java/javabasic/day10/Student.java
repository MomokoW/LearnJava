package javabasic.day10;

/**
 * Created by momoko on 2020/11/11.
 */
public class Student {
    private String name;
    private int age;
    private String school;
    private String major;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String school) {
        this(name, age);
        this.school = school;
    }

    public Student(String name, int age, String school, String major) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.major = major;
    }

}