package cn.xupt.entity;


import java.util.Date;

/**
 * Created by Admin on 2016/11/14.
 */
public class Parcel {

    private String awb;
    private String set_stu_id;
    private String location_1_id;
    private String other_1;
    private String location_2_id;
    private String other_2;
    private String type;
    private String company;
    private double reward;
    private String create_time;
    private String weight;
    private String size;
    private int par_status;

    public Parcel(){
        this.par_status = -1;
        this.awb = String.valueOf(new Date().getTime());
    }

    public String getAwb() {
        return awb;
    }

    public void setAwb(String awb) {
        this.awb = awb;
    }

    public String getSet_stu_id() {
        return set_stu_id;
    }

    public void setSet_stu_id(String set_stu_id) {
        this.set_stu_id = set_stu_id;
    }

    public String getLocation_1_id() {
        return location_1_id;
    }

    public void setLocation_1_id(String location_1_id) {
        this.location_1_id = location_1_id;
    }

    public String getOther_1() {
        return other_1;
    }

    public void setOther_1(String other_1) {
        this.other_1 = other_1;
    }

    public String getLocation_2_id() {
        return location_2_id;
    }

    public void setLocation_2_id(String location_2_id) {
        this.location_2_id = location_2_id;
    }

    public String getOther_2() {
        return other_2;
    }

    public void setOther_2(String other_2) {
        this.other_2 = other_2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPar_status() {
        return par_status;
    }

    public void setPar_status(int par_status) {
        this.par_status = par_status;
    }
}
