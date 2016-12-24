package cn.xupt.entity;

/**
 * Created by Admin on 2016/12/24.
 */
public class ParcelInfo {

    private String parcel_id;
    private String order_id;
    private String location_1;
    private String location_2;
    private String start_time;
    private String end_time;
    private String receive_time;
    private String create_time;
    private String par_status;
    private String status_code;
    private String order_status;

    @Override
    public String toString() {
        return "ParcelInfo{" +
                "parcel_id='" + parcel_id + '\'' +
                ", location_1='" + location_1 + '\'' +
                ", location_2='" + location_2 + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", receive_time='" + receive_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", par_status='" + par_status + '\'' +
                ", status_code='" + status_code + '\'' +
                '}';
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getParcel_id() {
        return parcel_id;
    }

    public void setParcel_id(String parcel_id) {
        this.parcel_id = parcel_id;
    }

    public String getPar_status() {
        return par_status;
    }

    public void setPar_status(String par_status) {
        this.par_status = par_status;
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

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }
}
