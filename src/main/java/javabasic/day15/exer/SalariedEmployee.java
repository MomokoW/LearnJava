package javabasic.day15.exer;

/**
 * Created by momoko on 2020/12/11.
 */
public class SalariedEmployee extends Employee {
    private double monthlySalary; //月工资

    public SalariedEmployee(String name, int number, MyDate birthDay, int monthlySalary) {
        super(name, number, birthDay);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() +
                "monthlySalary=" + monthlySalary +
                '}';
    }
}