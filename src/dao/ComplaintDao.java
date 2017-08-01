package dao;

import domain.Complaint;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.*;

/**
 * Created by Administrator on 2017\4\27 0027.
 */
public class ComplaintDao {

    public void insertComplaint(String c_content,String c_tname,String me_name) {

//        String sql = "";
//        DBUtils.executeUpdate(sql, c_content, c_tname, me_name);

        try {
            Connection connection = getConnection();

            String sql="INSERT INTO complaint(c_content,c_time,c_tname,me_name) VALUES(?,CURRENT_DATE,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,c_content);
            preparedStatement.setString(2,c_tname);
            preparedStatement.setString(3,me_name);
            preparedStatement.executeUpdate();//执行语句
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            getClose();
        }

    }

    public List<Complaint> selectComplaint() throws Exception {//4

//        String sql = new StringBuilder()
//                .append("SELECT c_id, c_time ")
//                .append("FROM compliants")
//                .toString();

//        String sql = "";
//        return DBUtils.<Complaint>executeQuery(sql);

        Connection connection = getConnection();

        String sql="SELECT c_id,c_content,c_time,c_tname,me_name FROM complaint ORDER BY c_id DESC";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Complaint> complaints=new ArrayList<>();
        while(resultSet.next()){
            Complaint complaint=new Complaint();
            complaint.setC_id(resultSet.getInt(1));
            complaint.setC_content(resultSet.getString(2));
            complaint.setC_time(resultSet.getString(3));
            complaint.setC_tname(resultSet.getString(4));
            complaint.setMe_name(resultSet.getString(5));
            complaints.add(complaint);
        }

        getClose();
        return complaints;
    }


}
