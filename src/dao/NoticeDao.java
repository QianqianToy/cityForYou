package dao;

import domain.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.*;

/**
 * Created by Administrator on 2017\4\27 0027.
 */
public class NoticeDao {

    public static void insertNotice(String n_content) throws Exception {
        Connection connection = getConnection();

        String sql="INSERT INTO notice(n_id,n_content,n_time) VALUES(n_id,?,CURRENT_DATE )";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,n_content);
        preparedStatement.executeUpdate();//执行语句

        getClose();

    }

    public static List<Notice> selectNotice() throws Exception {
        Connection connection = getConnection();

        String sql="SELECT n_id,n_content,n_time FROM Notice ORDER BY n_id DESC";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Notice> notices=new ArrayList<>();
        while(resultSet.next()){
            Notice notice=new Notice();
            notice.setN_id(resultSet.getInt(1));
            notice.setN_content(resultSet.getString(2));
            notice.setN_time(resultSet.getString(3));
            notices.add(notice);
        }

        getClose();
        return notices;
    }

    public void deleteNotice(int n_id) throws Exception {
        Connection connection = getConnection();

        String sql="DELETE FROM notice WHERE n_id = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setInt(1,n_id);
        preparedStatement.executeUpdate();//执行语句

        getClose();

    }

}


