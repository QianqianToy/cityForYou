package dao;

import domain.Member;
import domain.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.*;

/**
 * TODO()
 * Created by zqq on 2017/4/25 0025.
 */
public class MemberDao {

    public  int insert(Member member) throws Exception{//注册

        Connection connection = getConnection();

        String sql = "INSERT INTO members(me_name, passwd, me_type, phone, sex, reputation) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,member.getMe_name());
        preparedStatement.setString(2,member.getPassword());
        preparedStatement.setString(3,"普通用户");
        preparedStatement.setString(4,member.getPhone());
        preparedStatement.setString(5,member.getSex());
        preparedStatement.setInt(6,0);
        int result = preparedStatement.executeUpdate();

        getClose();
        return result;

    }

    public  boolean isIn(String name) throws Exception{//判断有没有已存在的用户名

        Connection connection = getConnection();

        String sql = " SELECT me_name FROM members WHERE  me_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();

        getClose();
        return result;
    }

    public boolean selectBy(String name,String password,String type) throws Exception{//登录

        Connection connection = getConnection();

        String sql = "SELECT me_name,passwd,me_type FROM members where me_name = ? AND  " +
                      "passwd = ? and me_type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,type);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();

        getClose();
        return result;
    }

    public void updateMember(String name,String passwd,String phone,String sex)throws Exception{
        Connection connection = getConnection();

        String sql = "UPDATE members SET passwd = ?,phone = ?,sex = ? WHERE me_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,passwd);
        preparedStatement.setString(2,phone);
        preparedStatement.setString(3,sex);
        preparedStatement.setString(4,name);
        preparedStatement.executeUpdate();
        getClose();
    }

    public List<Member> selectAll() throws Exception{//查询所有

        Connection connection = getConnection();

        String sql = "SELECT me_name,passwd,me_type,phone,sex,reputation FROM members WHERE me_type LIKE '普通用户'";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Member> members = new ArrayList<>();
        while(resultSet.next()){
            Member member = new Member();
            member.setMe_name(resultSet.getString(1));
            member.setPassword(resultSet.getString(2));
            member.setMe_type(resultSet.getString(3));
            member.setPhone(resultSet.getString(4));
            member.setSex(resultSet.getString(5));
            member.setReputation(resultSet.getInt(6));
            members.add(member);
        }
        getClose();
        return members;
    }

    public List<Member> selectByName(String me_name) throws Exception{//查询这个用户

        Connection connection = getConnection();

        String sql = "SELECT me_name,passwd,me_type,phone,sex,reputation FROM members " +
                "WHERE me_name LIKE ? AND me_type LIKE '普通用户'";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"%" + me_name + "%");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Member> members = new ArrayList<>();
        while(resultSet.next()){
            Member member = new Member();
            member.setMe_name(resultSet.getString(1));
            member.setPassword(resultSet.getString(2));
            member.setMe_type(resultSet.getString(3));
            member.setPhone(resultSet.getString(4));
            member.setSex(resultSet.getString(5));
            member.setReputation(resultSet.getInt(6));
            members.add(member);
        }
        getClose();
        return members;
    }

    public void deleteMember(String me_name) throws Exception {
        Connection connection = getConnection();

        String sql="DELETE FROM members WHERE me_name = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,me_name);
        preparedStatement.executeUpdate();//执行语句

        getClose();

    }

    public static void main(String[] args) throws Exception{
        new MemberDao().updateMember("张倩倩","123","1234567890","女");
    }

    //修改信用度
    public int sub(String me_name) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/merc";
        Connection connection = DriverManager.getConnection(url,"root","123");
        String sql = "UPDATE members SET reputation=(reputation-3) WHERE me_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,me_name);

        int result=preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return result;
    }

    public int add(String me_name) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/merc";
        Connection connection = DriverManager.getConnection(url,"root","123");
        String sql = "UPDATE members SET reputation=(reputation+1) WHERE me_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,me_name);

        int result=preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return result;
    }

}
