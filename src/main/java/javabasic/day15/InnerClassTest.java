package javabasic.day15;

/**
 * Created by momoko on 2020/12/11.
 */
class InnerClass {
    public static void main(String[] args) {
        Person p = new Person();
        Person.Brian brian = p.new Brian();
        brian.show("chifan");

    }
}

class Person {
    String name;
    class Brian {
        String name;

        void show(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }

    }

    public void method() {

        class AA {

        }
    }

    public Comparable getComparable() {
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

    }
}