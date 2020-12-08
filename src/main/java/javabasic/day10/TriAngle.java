package javabasic.day10;

/**
 * Created by momoko on 2020/11/11.
 */
public class TriAngle {

    private int base;
    private int height;

    public TriAngle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getArea() {
        return base * height / 2;
    }
}