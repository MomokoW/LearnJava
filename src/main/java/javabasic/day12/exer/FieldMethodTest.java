package javabasic.day12.exer;

/**
 * Created by momoko on 2020/12/8.
 */

class Base {
    int count  = 10;
    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count  = 20;
    public void display() {
        System.out.println(this.count);
    }
}
public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);
        s.display();
        Base b = s;
        //==:对于引用数据类型来讲，比较的是两个引用数据类型变量的地址值是否相同
        System.out.println(b == s);
        //多态性不适用成员变量
        System.out.println(b.count);
        b.display();
    }
}