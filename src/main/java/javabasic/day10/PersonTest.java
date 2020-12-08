package javabasic.day10;

/**
 * Created by momoko on 2020/11/11.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(12);

        System.out.println("年龄为:" + p1.getAge());
    }
}