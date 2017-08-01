package domain;

/**
 * Created by Administrator on 2017\4\27 0027.
 */
public class Notice {
    private Integer n_id;
    private String n_content;
    private String n_time;

    public Integer getN_id() {
        return n_id;
    }

    public void setN_id(Integer n_id) {
        this.n_id = n_id;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public String getN_time() {
        return n_time;
    }

    public void setN_time(String n_time) {
        this.n_time = n_time;
    }

    public String [] toStringArray() {//按照这个格式排列
        return new String[] {n_id.toString(), n_content, n_time};
    }
}

