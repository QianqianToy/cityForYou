package dao;

import domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.*;

/**
 * Created by zy on 2017/4/27.
 */
public class TaskDao {

    //查找历史任务
    public List<Task> selectHistoryByName(String t_name) throws Exception {

        Connection connection = getConnection();

        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT t_id,t_name,t_type,t_content,tme_name,me_name," +
                "start_time,end_time,address,reward,penalty,state FROM tasks WHERE t_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, t_name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Task task = new Task();
            task.setT_id(resultSet.getInt(1));
            task.setT_name(resultSet.getString(2));
            task.setT_type(resultSet.getString(3));
            task.setT_content(resultSet.getString(4));
            task.setTme_name(resultSet.getString(5));
            task.setMe_name(resultSet.getString(6));
            task.setStart_time(resultSet.getString(7));
            task.setEnd_time(resultSet.getString(8));
            task.setAddress(resultSet.getString(9));
            task.setReward(resultSet.getInt(10));
            task.setPenalty(resultSet.getInt(11));
            task.setState(resultSet.getString(12));
            tasks.add(task);
        }

        getClose();
        return tasks;
    }

    //删除历史任务
    public int deleteHistoryById(int t_id) throws Exception {

        Connection connection = getConnection() ;

        String sql = " DELETE FROM tasks WHERE  t_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, t_id);

        int result = preparedStatement.executeUpdate();

        getClose();
        return result;
    }

    //改变状态
    public void changeState(int t_id, String afterState) throws Exception {

        Connection connection = getConnection();

        String sql = "UPDATE tasks SET state = ? WHERE t_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, afterState);
        preparedStatement.setInt(2, t_id);
        preparedStatement.executeUpdate();

        getClose();
    }

    public List<Task> selectBy(String name) throws Exception {//查询登录用户的已发布任务
        List<Task> taskList = new ArrayList<>();

        Connection connection = getConnection();

        String sql = "SELECT * FROM Tasks WHERE me_name=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task1 = new Task();
            task1.setT_id(resultSet.getInt(1));
            task1.setT_name(resultSet.getString(2));
            task1.setT_type(resultSet.getString(3));
            task1.setT_content(resultSet.getString(4));
            task1.setMe_name(resultSet.getString(5));
            task1.setTme_name(resultSet.getString(6));
            task1.setStart_time(resultSet.getString(7));
            task1.setEnd_time(resultSet.getString(8));
            task1.setAddress(resultSet.getString(9));
            task1.setReward(resultSet.getInt(10));
            task1.setPenalty(resultSet.getInt(11));
            task1.setState(resultSet.getString(12));
            taskList.add(task1);
        }

        getClose();
        return taskList;
    }

    public List<Task> searchBy(String name) throws Exception {//在已发布任务里搜索
        List<Task> taskList = new ArrayList<>();
        Connection connection = getConnection();

        String sql = "SELECT  t_id,t_name,t_type,t_content, me_name, tme_name,start_time,end_time," +
                "address,reward FROM Tasks WHERE  t_name LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task1 = new Task();
            task1.setT_id(resultSet.getInt(1));
            task1.setT_name(resultSet.getString(2));
            task1.setT_type(resultSet.getString(3));
            task1.setT_content(resultSet.getString(4));
            task1.setMe_name(resultSet.getString(5));
            task1.setTme_name(resultSet.getString(6));
            task1.setStart_time(resultSet.getString(7));
            task1.setEnd_time(resultSet.getString(8));
            task1.setAddress(resultSet.getString(9));
            task1.setReward(resultSet.getInt(10));
            taskList.add(task1);
        }

        getClose();
        return taskList;
    }

    //树 显示
    public static List<Task> selectTasks(String type) throws Exception{
        List<Task> aptTasks = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT t_name FROM tasks WHERE t_type = ? and state = '待接受'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,type);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Task aptTask = new Task();
            aptTask.setT_name(resultSet.getString(1));
            aptTasks.add(aptTask);
        }
        getClose();
        return aptTasks;
    }

    //根据任务名字查询任务
    public static List<Task> selectAptTask(String name) throws Exception{
        List<Task> aptTasks = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT t_id,t_name,t_type,t_content,me_name,start_time,end_time," +
                "address,reward,penalty FROM tasks WHERE t_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Task aptTask = new Task();
            aptTask.setT_id(resultSet.getInt(1));
            aptTask.setT_name(resultSet.getString(2));
            aptTask.setT_type(resultSet.getString(3));
            aptTask.setT_content(resultSet.getString(4));
            aptTask.setMe_name(resultSet.getString(5));
            aptTask.setStart_time(resultSet.getString(6));
            aptTask.setEnd_time(resultSet.getString(7));
            aptTask.setAddress(resultSet.getString(8));
            aptTask.setReward(resultSet.getInt(9));
            aptTask.setPenalty(resultSet.getInt(10));

            aptTasks.add(aptTask);
        }
        getClose();
        return aptTasks;
    }

    //树 接任务
    public static void updateState(String tname,String name) throws Exception{

        Connection connection = getConnection();
        String sql = "UPDATE tasks SET tme_name = ?,state = '已接受'WHERE t_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString( 1,tname);
        preparedStatement.setString(2,name);
        preparedStatement.executeUpdate();

        getClose();
    }

    //模糊任务查询（待接受）
    public static List<Task> slurSelectTasks(String nameg) throws Exception{
        List<Task> aptTasks = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT t_id,t_name,t_type,t_content,me_name,start_time,end_time," +
                "address,reward,penalty FROM tasks WHERE tasks.state = '待接受' AND t_name LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"%"+nameg+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Task aptTask = new Task();
            aptTask.setT_id(resultSet.getInt(1));
            aptTask.setT_name(resultSet.getString(2));
            aptTask.setT_type(resultSet.getString(3));
            aptTask.setT_content(resultSet.getString(4));
            aptTask.setMe_name(resultSet.getString(5));
            aptTask.setStart_time(resultSet.getString(6));
            aptTask.setEnd_time(resultSet.getString(7));
            aptTask.setAddress(resultSet.getString(8));
            aptTask.setReward(resultSet.getInt(9));
            aptTask.setPenalty(resultSet.getInt(10));

            aptTasks.add(aptTask);
        }

        getClose();
        return aptTasks;
    }

    //接受任务
    public static void slurUpdataState(String tname,Integer id) throws Exception{
        Connection connection = getConnection();
        String sql = "UPDATE tasks SET tme_name = ?,state = '已接受' WHERE t_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString( 1,tname);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();

        getClose();
    }

    //根据状态查找任务
    public List<Task> selectTaskByState(String state1, String state2) throws Exception {
        Connection connection = getConnection();
        List<Task> taskList = new ArrayList<>();
        String sql = "SELECT * FROM Tasks WHERE state = ? OR state = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, state1);
        preparedStatement.setString(2, state2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task1 = new Task();
            task1.setT_id(resultSet.getInt(1));
            task1.setT_name(resultSet.getString(2));
            task1.setT_type(resultSet.getString(3));
            task1.setT_content(resultSet.getString(4));
            task1.setMe_name(resultSet.getString(5));
            task1.setTme_name(resultSet.getString(6));
            task1.setStart_time(resultSet.getString(7));
            task1.setEnd_time(resultSet.getString(8));
            task1.setAddress(resultSet.getString(9));
            task1.setReward(resultSet.getInt(10));
            task1.setPenalty(resultSet.getInt(11));
            task1.setState(resultSet.getString(12));
            taskList.add(task1);
        }
        getClose();
        return taskList;
    }

    //模糊查询
    public static List<Task> SelectTasksByName(String name) throws Exception{
        List<Task> aptTasks = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT t_id,t_name,t_type,t_content,me_name,start_time,end_time," +
                "address,reward,penalty FROM tasks WHERE me_name LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Task aptTask = new Task();
            aptTask.setT_id(resultSet.getInt(1));
            aptTask.setT_name(resultSet.getString(2));
            aptTask.setT_type(resultSet.getString(3));
            aptTask.setT_content(resultSet.getString(4));
            aptTask.setMe_name(resultSet.getString(5));
            aptTask.setStart_time(resultSet.getString(6));
            aptTask.setEnd_time(resultSet.getString(7));
            aptTask.setAddress(resultSet.getString(8));
            aptTask.setReward(resultSet.getInt(9));
            aptTask.setPenalty(resultSet.getInt(10));

            aptTasks.add(aptTask);
        }

        getClose();
        return aptTasks;
    }

    //根据账号和任务状态查任务
    public List<Task> selectTaskByNameAndState(String me_name, String state1, String state2) throws Exception {
        Connection connection = getConnection();
        List<Task> taskList = new ArrayList<>();
        String sql = "SELECT * FROM Tasks WHERE me_name = ? AND (state = ? OR state = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, me_name);
        preparedStatement.setString(2, state1);
        preparedStatement.setString(3, state2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task1 = new Task();
            task1.setT_id(resultSet.getInt(1));
            task1.setT_name(resultSet.getString(2));
            task1.setT_type(resultSet.getString(3));
            task1.setT_content(resultSet.getString(4));
            task1.setMe_name(resultSet.getString(5));
            task1.setTme_name(resultSet.getString(6));
            task1.setStart_time(resultSet.getString(7));
            task1.setEnd_time(resultSet.getString(8));
            task1.setAddress(resultSet.getString(9));
            task1.setReward(resultSet.getInt(10));
            task1.setPenalty(resultSet.getInt(11));
            task1.setState(resultSet.getString(12));
            taskList.add(task1);
        }
        getClose();
        return taskList;
    }

    //删除任务
    public void deleteTaskById(int t_id) throws Exception {

        Connection connection = getConnection();

        String sql = "DELETE FROM tasks  WHERE t_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, t_id);
        int result = preparedStatement.executeUpdate();

        getClose();
    }

    //发布任务
    public int into(Task task)throws Exception {
        Connection connection= getConnection();
        String sql="INSERT INTO tasks(t_name,t_type,t_content,me_name,start_time,end_time,address,reward,penalty,state) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,task.getT_name());
        preparedStatement.setString(2,task.getT_type());
        preparedStatement.setString(3,task.getT_content());
        preparedStatement.setString(4,task.getMe_name());
        preparedStatement.setString(5,task.getStart_time());
        preparedStatement.setString(6,task.getEnd_time());
        preparedStatement.setString(7,task.getAddress());
        preparedStatement.setInt(8,task.getReward());
        preparedStatement.setInt(9,task.getPenalty());
        preparedStatement.setString(10,task.getState());

        int result=preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return result;
    }

}
