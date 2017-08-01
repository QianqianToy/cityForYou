package domain;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class Senses {

    private Integer s_id;
    private String s_words;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_words() {
        return s_words;
    }

    public void setS_words(String s_words) {
        this.s_words = s_words;
    }

    public String [] toStringArrays() {
        return new String[] {s_words};
    }
}
