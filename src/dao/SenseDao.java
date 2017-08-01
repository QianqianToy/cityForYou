package dao;

import domain.Senses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2017/5/6.
 */
public class SenseDao {

    public static List<Senses> select() throws Exception {
        List<Senses> list=new ArrayList();

        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/merc";
        Connection connection= DriverManager.getConnection(url,"root","123");
        String sql="SELECT s_words FROM senses";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Senses senses = new Senses();
            senses.setS_words(resultSet.getString(1));
            list.add(senses);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }

    public int into(Senses senses)throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/merc";
        Connection connection= DriverManager.getConnection(url,"root","123");
        String sql="INSERT INTO senses(s_words) VALUES(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,senses.getS_words());

        int result=preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return result;
    }

    public int delete(String senses)throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/merc";
        Connection connection= DriverManager.getConnection(url,"root","123");
        String sql="DELETE FROM  senses WHERE s_words = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,senses);

        int result=preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return result;
    }

    public boolean isIn(String s_words) throws Exception { //将任务描述传进来
        List<Senses> senses = select();
        for (Senses s: senses){
            int a = s_words.indexOf(s.getS_words());
            if(a >= 0) {
                return false;
            }
        }
        return true;
    }

}
