package javabasic.day14;

/**
 * Created by momoko on 2020/12/10.
 * 类的成员之四：代码块（或初始化块）
 * 1.代码块的作用：用来初始化化类、对象
 * 2.分类：静态代码块VS非静态代码块
 * 3.静态代码块：
 *     >内部可以有输出语句
 *     >随着类的加载而执行，而且只执行一次
 *     >作用：初始化类的信息
 *     >如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 * 4.非静态代码块
 *     >内部可以有输出语句
 *     >随着对象的创建而执行，每创建一次就执行一次
 *     >作用：可以在创建对象时对对象的属性进行初始化
 *     >如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 *     >代码块先于构造器执行
 *     >静态代码块先于非静态代码块执行
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        Person p1 = new Person();
        Person p2 = new Person();

    }
}

class Person{
    String name;
    int age;
    static String desc = "I'm a person";

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //代码块
    {
        System.out.println("hello, non static block");
        eat();

    }

    static {
        System.out.println("hello,static block");

    }

    public void eat() {
        System.out.println("吃");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}