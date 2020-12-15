package javabasic.day14;

/**
 * Created by momoko on 2020/12/10.
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1 == order2);
    }
}
//懒汉式
class Order {

    //1.私有化类的构造器
    private Order() {

    }

    //2.声明当前类的对象，没有初始化
    private static Order instance = null;

    //3.声明public、static的返回当前类的方法
    //加上synchronized关键字就是线程安全的，但是效率比较低
//    public static synchronized Order getInstance() {
//        if(instance == null) {
//            instance = new Order();
//        }
//        return instance;
//    }

    public static Order getInstance() {
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }
}