package javabasic.day12;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by momoko on 2020/11/17.
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        cy.setRadius(2.1);
        cy.setLength(3.5);
        double volume = cy.findVolume();

        boolean isSub = cy instanceof InterfaceA;
        System.out.println(isSub);

        System.out.println("圆柱的体积为" + volume);

        List<String> list = List.of("Tom", "Jerry", "Tim");
        Optional<List<String>> list1 = Optional.ofNullable(list);
        Stream<List<String>> stream = list1.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
        var num = 10;
    }
}