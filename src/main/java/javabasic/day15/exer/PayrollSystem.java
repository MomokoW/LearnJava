package javabasic.day15.exer;

/**
 * Created by momoko on 2020/12/11.
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] emps = new Employee[2];
        emps[0] = new SalariedEmployee("jack",1001,new MyDate(1989,2,3),5000);
        emps[1] = new HourlyEmployee("rose",1002,new MyDate(1990,2,4),400,6);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
            System.out.println("月工资为：" + emps[i].earnings());
        }


    }
}