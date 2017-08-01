package service;

import dao.NoticeDao;
import domain.Notice;

import java.util.List;

/**
 * Created by Administrator on 2017\4\28 0028.
 */
public class NoticeService {

    private NoticeDao noticeDao = new NoticeDao();

    public void addNotice(String n_content) throws Exception {
        noticeDao.insertNotice(n_content);
    }

    public List<Notice> findNotice() throws Exception{
        return noticeDao.selectNotice();
    }

    public void delNotice(int n_id) throws Exception {
        noticeDao.deleteNotice(n_id);
    }

}
