package javabasic.day15;

/**
 * Created by momoko on 2020/12/11.
 */
public class InterfaceTest {
    public static void main(String[] args) {

        Plane plane = new Plane();
        plane.fly();
    }
}

interface Flyable {
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;
    public abstract void fly();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("飞机能飞");
    }
}