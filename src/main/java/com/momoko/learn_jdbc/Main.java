package com.momoko.learn_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by momoko on 2020/6/23.
 */

/**
 * Statment和ResultSet都是需要关闭的资源，因此嵌套使用try (resource)确保及时关闭；
 *
 * rs.next()用于判断是否有下一行记录，如果有，将自动把当前行移动到下一行（一开始获得ResultSet时当前行不是第一行）；
 *
 * ResultSet获取列时，索引从1开始而不是0；
 *
 * 必须根据SELECT的列的对应位置来调用getLong(1)，getString(2)这些方法，否则对应位置的数据类型不对，将报错。
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123456";
        // 获取连接:
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (Statement stat = conn.createStatement()) {
                try (ResultSet rs = stat.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
                    while (rs.next()) {
                        Long id = rs.getLong(1); // 注意：索引从1开始
                        Long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
//                        System.out.println(id + " |" + grade + " |" + name + " |" + gender + " |");
                    }
                }
            }

            //使用PrepareStatement进行查询
            try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
                ps.setObject(1,1);
                ps.setObject(2,2);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {Long id = rs.getLong(1); // 注意：索引从1开始
                        Long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println(id + " |" + grade + " |" + name + " |" + gender + " |");
                    }
                }
            }

            //插入新内容
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (id, grade, name, gender, score) VALUES (?,?,?,?,?)")) {
                ps.setObject(1, 999);
                ps.setObject(2, 1);
                ps.setObject(3, "Bob");
                ps.setObject(4, 1);
                ps.setObject(5, 95);
//                int n = ps.executeUpdate();
//                System.out.println(n);

            }

            //更新数据
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
                ps.setObject(1, "Lily"); // 注意：索引从1开始
                ps.setObject(2, 999);
                int n = ps.executeUpdate(); // 返回更新的行数
            }

            //删除数据
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
                ps.setObject(1, 999); // 注意：索引从1开始
                int n = ps.executeUpdate(); // 删除的行数
            }
        }
    }
}