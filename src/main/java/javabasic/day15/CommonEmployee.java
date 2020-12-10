package javabasic.day15;

/**
 * Created by momoko on 2020/12/10.
 */
public class CommonEmployee extends Employee{
    @Override
    public void work() {
        System.out.println("普通员工正在工作");
    }

    public CommonEmployee() {
    }

    public CommonEmployee(String name, int id, Double salary) {
        super(name, id, salary);
    }
}