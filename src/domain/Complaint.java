package domain;

/**
 * Created by Administrator on 2017\4\30 0030.
 */
public class Complaint {
    private Integer c_id;
    private String c_content;
    private String c_time;
    private String c_tname;
    private String me_name;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getC_tname() {
        return c_tname;
    }

    public void setC_tname(String c_tname) {
        this.c_tname = c_tname;
    }

    public String getMe_name() {
        return me_name;
    }

    public void setMe_name(String me_name) {
        this.me_name = me_name;
    }

    public String [] toStringArray() {//按照这个格式排列
        return new String[] {c_id.toString(),c_content,c_time,c_tname,me_name};
    }
}
