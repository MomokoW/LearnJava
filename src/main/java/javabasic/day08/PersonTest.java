package javabasic.day08;

/**
 * Created by momoko on 2020/11/9.
 */
public class PersonTest {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "Tom";
        p1.isMale = true;
        p1.eat();
        p1.eat(1);
        System.out.println(p1);

    }
}

class Person {
    public String name;
    public int age = 1;
    public boolean isMale;

    public void eat() {
        System.out.println("吃");
    }
    public int eat(int a) {
        return a;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}