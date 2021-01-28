package javabasic.day12;

/**
 * Created by momoko on 2020/11/17.
 */
public class Cylinder extends Circle implements InterfaceA{
    private double length;

    public Cylinder() {
        length = 1.0;
    }


    public double findVolume() {
        return findArea() * getLength();
    }
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}