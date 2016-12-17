package cn.xupt.entity;

/**
 * Created by Admin on 2016/12/17.
 */
public class Problem {

    private String problem_id;
    private String ask_stu_id;
    private String deal_people_id;
    private String problem_info;
    private String pr_status;

    @Override
    public String toString() {
        return "Problem{" +
                "problem_id='" + problem_id + '\'' +
                ", ask_stu_id='" + ask_stu_id + '\'' +
                ", deal_people_id='" + deal_people_id + '\'' +
                ", problem_info='" + problem_info + '\'' +
                ", pr_status='" + pr_status + '\'' +
                '}';
    }

    public String getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(String problem_id) {
        this.problem_id = problem_id;
    }

    public String getAsk_stu_id() {
        return ask_stu_id;
    }

    public void setAsk_stu_id(String ask_stu_id) {
        this.ask_stu_id = ask_stu_id;
    }

    public String getDeal_people_id() {
        return deal_people_id;
    }

    public void setDeal_people_id(String deal_people_id) {
        this.deal_people_id = deal_people_id;
    }

    public String getProblem_info() {
        return problem_info;
    }

    public void setProblem_info(String problem_info) {
        this.problem_info = problem_info;
    }

    public String getPr_status() {
        return pr_status;
    }

    public void setPr_status(String pr_status) {
        this.pr_status = pr_status;
    }
}
