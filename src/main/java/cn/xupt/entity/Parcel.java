package cn.xupt.entity;


/**
 * Created by Admin on 2016/11/14.
 */
public class Parcel {

    private String set_stu_id;
    private String localtion_1;
    private String localtion_2;
    private String type;
    private String company;
    private double reward;
    private String create_time;
    private String deadline;
    private String weight;
    private String size;
    private int par_status;



    public String getSet_stu_id() {
        return set_stu_id;
    }

    public void setSet_stu_id(String set_stu_id) {
        this.set_stu_id = set_stu_id;
    }

    public String getLocaltion_1() {
        return localtion_1;
    }

    public void setLocaltion_1(String localtion_1) {
        this.localtion_1 = localtion_1;
    }

    public String getLocaltion_2() {
        return localtion_2;
    }

    public void setLocaltion_2(String localtion_2) {
        this.localtion_2 = localtion_2;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
