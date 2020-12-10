package javabasic.day13;

import java.util.Objects;

/**
 * Created by momoko on 2020/12/8.
 */
public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
//        super();
        this.radius = radius;
    }

    public
    Circle(double radius, String color, double weight) {
//        super(color, weight);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}