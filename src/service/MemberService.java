package service;

import dao.MemberDao;
import domain.Member;
import domain.Task;

import java.util.List;

/**
 * TODO()
 * Created by zqq on 2017/4/25 0025.
 */
public class MemberService {

    private MemberDao memberDao = new MemberDao();

    public int register(Member member)throws Exception{
        return memberDao.insert(member);
    }

    public boolean judge(String name)throws Exception{
        return memberDao.isIn(name);
    }

    public int findBy(String name,String password,String type) throws Exception{
        if(memberDao.selectBy(name,password,type))
           return 1;
        return 0;
    }
    public void updateMemberByName(String name,String passwd,String phone,String sex)throws Exception{
        memberDao.updateMember(name,passwd,phone,sex);
    }

    public List<Member> findAll() throws Exception {
        return memberDao.selectAll();
    }

    public void delByName(String me_name) throws Exception {
        memberDao.deleteMember(me_name);
    }

    public List<Member> findByName(String me_name) throws Exception {
        return memberDao.selectByName(me_name);
    }

    //修改信用度
    public void addReputation(String me_name) throws Exception {
        memberDao.add(me_name);
    }

    public void subReputation(String me_name) throws Exception {
        memberDao.sub(me_name);
    }

}
