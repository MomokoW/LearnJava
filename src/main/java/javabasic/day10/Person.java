package javabasic.day10;

/**
 * Created by momoko on 2020/11/11.
 */
public class Person {

    private int age;

    public void setAge(int a) {
        if(a < 0 || a > 130) {
            System.out.println("传入的数据非法");
            return;
        }

        age = a;
    }

    public int getAge() {
        return age;
    }
}