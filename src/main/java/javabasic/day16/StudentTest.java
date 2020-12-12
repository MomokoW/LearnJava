package javabasic.day16;

/**
 * Created by momoko on 2020/12/12.
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.regist(-1000);
        System.out.println(student);
    }
}
class Student {
    private int id;

    public void regist(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            //手动抛出异常
            throw new MyException("不能输入负数！");
        }
    }
}