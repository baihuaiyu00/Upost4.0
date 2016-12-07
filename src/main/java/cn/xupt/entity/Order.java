package cn.xupt.entity;

/**
 * Created by Admin on 2016/12/6.
 */
public class Order {

    private String order_id;
    private String get_stu_id;
    private String parcel_id;
    private long receive_time;
    private String order_status;

    public Order(){
        this.get_stu_id = "-1";
        this.parcel_id = "0";
        this.receive_time = -1;
        this.order_id = "-2";
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getGet_stu_id() {
        return get_stu_id;
    }

    public void setGet_stu_id(String get_stu_id) {
        this.get_stu_id = get_stu_id;
    }

    public String getParcel_id() {
        return parcel_id;
    }

    public void setParcel_id(String parcel_id) {
        this.parcel_id = parcel_id;
    }

    public long getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(long receive_time) {
        this.receive_time = receive_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
