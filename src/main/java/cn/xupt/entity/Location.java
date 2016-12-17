package cn.xupt.entity;

/**
 * Created by Admin on 2016/12/11.
 */
public class Location {

    private String belong_stu_id;
    private String location_type;
    private String use_time;
    private String location_txt;

    public Location(String belong_stu_id, String location_type, String use_time, String location_txt) {
        this.belong_stu_id = belong_stu_id;
        this.location_type = location_type;
        this.use_time = use_time;
        this.location_txt = location_txt;
    }

    public String getBelong_stu_id() {
        return belong_stu_id;
    }

    public void setBelong_stu_id(String belong_stu_id) {
        this.belong_stu_id = belong_stu_id;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getUse_time() {
        return use_time;
    }

    public void setUse_time(String use_time) {
        this.use_time = use_time;
    }

    public String getLocation_txt() {
        return location_txt;
    }

    public void setLocation_txt(String location_txt) {
        this.location_txt = location_txt;
    }
}
