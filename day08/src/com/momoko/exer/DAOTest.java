package com.momoko.exer;

import java.util.List;

/**
 * Created by momoko on 2021/1/14.
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();

        dao.save("1001",new User(1001, 34, "孙雨晴"));
        dao.save("1002",new User(1002, 34, "王尼玛"));

        List<User> list = dao.list();
        list.forEach(System.out::println);


    }
}