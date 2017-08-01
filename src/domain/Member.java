package domain;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class Member {
    private  Integer me_id;
    private  String me_name;
    private  String password;
    private  String me_type;
    private  String phone;
    private  String sex;
    private  Integer reputation;

    public Integer getMe_id() {
        return me_id;
    }

    public void setMe_id(Integer me_id) {
        this.me_id = me_id;
    }

    public String getMe_name() {
        return me_name;
    }

    public void setMe_name(String me_name) {
        this.me_name = me_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMe_type() {
        return me_type;
    }

    public void setMe_type(String me_type) {
        this.me_type = me_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String [] toStringArray() {
        return new String[] {me_name, password, me_type,phone,sex,reputation.toString()};
    }
}
