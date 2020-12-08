package javabasic.day12;

/**
 * Created by momoko on 2020/11/17.
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        cy.setRadius(2.1);
        cy.setLength(3.5);
        double volume = cy.findVolume();

        System.out.println("圆柱的体积为" + volume);
    }
}