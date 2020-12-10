package javabasic.day15;

/**
 * Created by momoko on 2020/12/10.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee manager = new Manager("库克", 1001, 3000.0, 20000);
        manager.work();
    }
}