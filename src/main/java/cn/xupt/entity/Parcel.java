package cn.xupt.entity;


import java.util.Date;

/**
 * Created by Admin on 2016/11/14.
 */
public class Parcel {
    private String parcel_id;
    private String set_stu_id;
    private String take_name;
    private String take_phone;
    private String location_1;
    private String location_2;
    private String type;
    private double reward;
    private String create_time;
    private String size;
    private String urgent;
    private String start_time;
    private String end_time;
    private String note;
    private int par_status;

    public Parcel(){
        this.set_stu_id = "9";
        this.par_status = -1;
        this.type = "1";
        this.reward = 6.66;
        this.size = "2";
        this.urgent = "0";
        this.start_time = "2016-03-31 11:11:11";
        this.end_time = "2016-03-31 11:11:11";
        this.note = "123";
    }

    public String getParcel_id() {
        return parcel_id;
    }

    public String getTake_name() {
        return take_name;
    }

    public void setTake_name(String take_name) {
        this.take_name = take_name;
    }

    public String getTake_phone() {
        return take_phone;
    }

    public void setTake_phone(String take_phone) {
        this.take_phone = take_phone;
    }

    public void setParcel_id(String parcel_id) {
        this.parcel_id = parcel_id;
    }

    public String getSet_stu_id() {
        return set_stu_id;
    }

    public void setSet_stu_id(String set_stu_id) {
        this.set_stu_id = set_stu_id;
    }

    public String getLocation_1() {
        return location_1;
    }

    public void setLocation_1(String location_1) {
        this.location_1 = location_1;
    }

    public String getLocation_2() {
        return location_2;
    }

    public void setLocation_2(String location_2) {
        this.location_2 = location_2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPar_status() {
        return par_status;
    }

    public void setPar_status(int par_status) {
        this.par_status = par_status;
    }
}
