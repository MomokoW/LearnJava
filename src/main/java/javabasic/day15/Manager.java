package javabasic.day15;

/**
 * Created by momoko on 2020/12/10.
 */
public class Manager extends Employee {
    private int bonus;
    @Override
    public void work() {
        System.out.println("管理者正在工作");
    }

    public Manager() {
    }

    public Manager(String name, int id, Double salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }
}