package service;

import dao.ComplaintDao;
import domain.Complaint;

import java.util.List;

/**
 * Created by Administrator on 2017\4\30 0030.
 */
public class ComplaintService {

    private ComplaintDao complaintDao = new ComplaintDao();

    public void addComplaint(String c_content,String c_tname,String me_name) throws Exception {
        complaintDao.insertComplaint(c_content, c_tname, me_name);
    }

    public List<Complaint> findComplaint() throws Exception{
        return complaintDao.selectComplaint();
    }

}
