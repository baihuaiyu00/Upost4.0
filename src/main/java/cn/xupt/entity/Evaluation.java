package cn.xupt.entity;

/**
 * Created by Admin on 2016/12/17.
 */
public class Evaluation {

    private String eval_id;
    private String belong_order_id;
    private String eval_time;
    private String speed;
    private String service;
    private String appearance;
    private String whether;
    private String eval_context;



    public String getEval_id() {
        return eval_id;
    }

    public void setEval_id(String eval_id) {
        this.eval_id = eval_id;
    }

    public String getBelong_order_id() {
        return belong_order_id;
    }

    public void setBelong_order_id(String belong_order_id) {
        this.belong_order_id = belong_order_id;
    }

    public String getEval_time() {
        return eval_time;
    }

    public void setEval_time(String eval_time) {
        this.eval_time = eval_time;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getWhether() {
        return whether;
    }

    public void setWhether(String whether) {
        this.whether = whether;
    }

    public String getEval_context() {
        return eval_context;
    }

    public void setEval_context(String eval_context) {
        this.eval_context = eval_context;
    }
}
