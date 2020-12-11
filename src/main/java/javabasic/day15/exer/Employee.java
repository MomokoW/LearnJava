package javabasic.day15.exer;

/**
 * Created by momoko on 2020/12/11.
 */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthDay;

    public abstract double earnings();

    public Employee(String name, int number, MyDate birthDay) {
        this.name = name;
        this.number = number;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return  "[name='" + name + '\'' +
                ", number=" + number +
                ", birthDay=" + birthDay.toDateString() +
                ']';
    }
}