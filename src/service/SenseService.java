package service;

import dao.SenseDao;
import domain.Senses;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zy on 2017/5/6.
 */
public class SenseService {

    private SenseDao senseDao = new SenseDao();

    public void wordUpSend(Senses w) throws Exception {
        senseDao.into(w);
    }

    public void wordDelete(String s) throws Exception {
        senseDao.delete(s);
    }

    public List<Senses> view() throws Exception {
        return senseDao.select();
    }

    public boolean badWordNotice(String s_word) throws Exception {
        return senseDao.isIn(s_word);
    }
}
