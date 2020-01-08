package java8lambda;

import com.sun.tools.javac.util.List;

import java.util.Objects;

/**
 * Created by sunyuqing on 2019/11/7.
 */
public class MyTestMain {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person p = (Person) obj;
            return Objects.equals(this.firstName+this.lastName, p.firstName+p.lastName) && this.age == p.age;
        }
        return false;
    }
}

