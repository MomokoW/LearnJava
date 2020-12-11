package javabasic.day15.exer;

/**
 * Created by momoko on 2020/12/11.
 */
public class HourlyEmployee extends Employee {
    private int wage;//每小时的工资
    private int hour;//月工作的小时数
    public HourlyEmployee(String name, int number, MyDate birthDay, int wage, int hour) {
        super(name, number, birthDay);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString() +
                "wage=" + wage +
                ", hour=" + hour +
                '}';
    }
}