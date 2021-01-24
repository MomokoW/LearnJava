package com.momoko.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by momoko on 2021/1/24.
 */
public class StreamAPITest {

    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream.skip(3).forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //拆分字符串
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(12, 34, 56, 78, 90, -55, -66, -7);
        list.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        Optional<Employee> em = employees.stream().findFirst();
        System.out.println(em);

        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        System.out.println(salaryStream.max(Double::compare));

        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
    }

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> sumMoney = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(sumMoney);
    }

    @Test
    public void test8() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}