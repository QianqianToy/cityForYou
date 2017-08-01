package domain;

/**
 * Created by zy on 2017/4/27.
 */
public class Task {

    private Integer t_id;
    private String t_name;
    private String t_type;
    private String t_content;
    private String tme_name;
    private String me_name;
    private String start_time;
    private String end_time;
    private String address;
    private Integer reward;
    private Integer penalty;
    private String state;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getTme_name() {
        return tme_name;
    }

    public void setTme_name(String tme_name) {
        this.tme_name = tme_name;
    }

    public String getMe_name() {
        return me_name;
    }

    public void setMe_name(String me_name) {
        this.me_name = me_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String[] taskToStringArray() {
        return new String[] {t_id.toString(), t_name, t_type, t_content,
                me_name,tme_name,start_time,end_time,address,
                reward.toString(),penalty.toString(),state};
    }

    public String[] ProcessToStringArrary(){
        return new String[]{t_name, t_type, t_content};
    }

    public String [] toStringArray() {
        return new String[] {getT_id().toString(),getT_name(),getT_type(),getT_content(),getMe_name(),getStart_time(),
                getEnd_time(),getAddress(),getReward().toString(),getPenalty().toString()};
    }

}
