package javabasic.day09;

/**
 * Created by momoko on 2020/11/10.
 */
public class PassObject {
    public static void main(String[] args) {
        PassObject test = new PassObject();
        Circle c = new Circle();
        test.printAreas(c,5);
        System.out.println("now radius is " + c.radius);
    }

    public void printAreas(Circle c, int time) {
        System.out.println("Radius\t\tArea");

        for (int i = 1; i <= 5; i++) {
            c.radius = i;
            System.out.println(c.radius + "\t\t" + c.findArea());
        }
        c.radius = time + 1;
    }
}