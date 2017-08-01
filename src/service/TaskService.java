package service;

import dao.TaskDao;
import domain.Task;

import java.util.List;

/**
 * Created by zy on 2017/4/27.
 */
public class TaskService {

    private TaskDao taskDao = new TaskDao();
    private String tname;

    public List<Task> findHistoryTask(String t_name) throws Exception {
        return taskDao.selectHistoryByName(t_name);
    }

    public int deleteHistoryTask(int t_id) throws Exception {
        return taskDao.deleteHistoryById(t_id);
    }

    public List<Task> selectTask(String name) throws Exception{
        return taskDao.selectBy(name);
    }

    public List<Task> searchTask(String name) throws Exception{
        return taskDao.searchBy(name);
    }

    public List<Task> findAllTasks(String  kind) throws Exception{
        return taskDao.selectTasks(kind);
    }

    public List<Task> getAptTask(String  name) throws Exception{
        return taskDao.selectAptTask(name);
    }

    public void updataStateByTname(String tname) throws Exception{
        this.tname = tname;
    }

    public void updateStateByName(String name) throws Exception{
        taskDao.updateState(tname,name);
    }

    //接受任务
    public void slurFindUpdataState(String tname,Integer id)throws Exception{
        taskDao.slurUpdataState(tname,id);
    }

    //模糊查询任务(待接受)
    public List<Task> slurFindTask(String name) throws Exception{
        return taskDao.slurSelectTasks(name);
    }

    //根据任务状态任务（未接受、已接受）
    public List<Task> findTaskByState(String state1, String state2) throws Exception {
        return taskDao.selectTaskByState(state1, state2);
    }

    //根据账号和状态查找任务
    public List<Task> findTaskByNameAndState(String me_name, String state1, String state2) throws Exception {
        return taskDao.selectTaskByNameAndState(me_name, state1, state2);
    }

    public void delTaskById(int t_id) throws Exception{
        taskDao.deleteTaskById(t_id);
    }

    //发布任务
    public void taskUpSend(Task task) throws Exception {
        taskDao.into(task);
    }

    //改变状态
    public void changeTaskState(int t_id, String afterState) throws Exception{
        taskDao.changeState(t_id, afterState);
    }

}
