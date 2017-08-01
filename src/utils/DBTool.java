package utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zy on 2017/5/4.
 */
public class DBTool {

    private static final String URL = "jdbc:postgresql://localhost:5432/dbtest";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static int executeUpdate(String sql, Object ... params) {
        try {
            try (Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    for (int i = 0; i < params.length; i++)
                        ps.setObject(i + 1, params[i]);
                    return ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> executeQuery(Class<T> clazz, String sql, Object ... params) {
        List<T> list = new ArrayList<>();
        try {
            try (Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    for (int i = 0; i < params.length; i++)
                        ps.setObject(i + 1, params[i]);
                    ResultSet rs = ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();//获取列的编号、类型、属性
                    while (rs.next()) {
                        T t = clazz.newInstance();//获取对象的新实例
                        int columns = rsmd.getColumnCount();//返回列数
                        for (int i = 1; i <= columns; i++) {
                            Field field = clazz.getDeclaredField(rsmd.getColumnLabel(i));//返回指定对象
                            field.setAccessible(true);
                            field.set(t, rs.getObject(i));//将rs.getObject(i)给t
                        }
                        list.add(t);
                    }
                }
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        List<User> users = DBTool.executeQuery(User.class, "SELECT * FROM users");
//        for (User u: users)
//            System.out.println(Arrays.toString(u.toStringArray()));

    }

}

