package javabasic.day10;

/**
 * Created by momoko on 2020/11/11.
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer("Jane", "Smith");
        Account account = new Account(1000, 2000, 0.0123);
        customer.setAccount(account);
        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);

    }
}