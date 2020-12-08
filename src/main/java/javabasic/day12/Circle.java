package javabasic.day12;

/**
 * Created by momoko on 2020/11/17.
 */
public class Circle {

    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}