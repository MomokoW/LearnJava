package javabasic.day15;

/**
 * Created by momoko on 2020/12/10.
 */
public abstract class Employee {

    private String name;
    private int id;
    private Double salary;

    public Employee() {
        super();
    }

    public Employee(String name, int id, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public abstract void  work();
}