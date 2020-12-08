package javabasic.day13;

/**
 * Created by momoko on 2020/12/8.
 */
public class OrderTest {

    public static void main(String[] args) {
        Order order1 = new Order(1, "No Speaking");
        Order order2 = new Order(1, "No speaking");
        System.out.println(order1 == order2);
        System.out.println(order1.equals(order2));
    }
}