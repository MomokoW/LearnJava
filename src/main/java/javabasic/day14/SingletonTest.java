package javabasic.day14;

/**
 * Created by momoko on 2020/12/10.
 * 懒汉式：
 *      好处：延迟对象的创建
 * 饿汉式：
 *      好处：饿汉式是线程安全
 *      坏处：加载时间过长
 */

public class SingletonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }

}

//饿汉式单例模式
class Bank{

    //私有化构造器
    private Bank(){

    }
    private static Bank instance = new Bank();

    public static Bank getInstance(){
        return instance;
    }
}