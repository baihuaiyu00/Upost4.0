package cn.xupt.entity;

/**
 * Created by Admin on 2016/11/10.
 */

/**
 * student information bean
 */
    public class User {

        public User(){
            this.school_id = "1";
            this.major = "some major";
            this.head = "path";
            this.stu_nickname = "someone";
            this.signature = "this user is suck";
            this.credibility = "100";
            this.set_order = "0";
            this.get_order = "0";
            this.stu_photo = "none";
            this.iden_photo = "none";
            this.audit_adm_id = "0";
            this.audit_status = "-1";
        }

    private String stu_num;
    private String stu_name;
    private String stu_phone;
    private String stu_passwd;
    private String email;
    private String school_id;
    private String major;
    private String stu_nickname;
    private String head;
    private String signature;
    private String credibility;
    private String integral;
    private String sex;
    private String set_order;
    private String get_order;
    private String stu_photo;
    private String iden_photo;
    private String audit_adm_id;
    private String audit_status;

    @Override
    public String toString() {
        return "User{" +
                "stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_phone='" + stu_phone + '\'' +
                ", stu_passwd='" + stu_passwd + '\'' +
                ", email='" + email + '\'' +
                ", school_id='" + school_id + '\'' +
                ", major='" + major + '\'' +
                ", stu_nickname='" + stu_nickname + '\'' +
                ", head='" + head + '\'' +
                ", signature='" + signature + '\'' +
                ", credibility='" + credibility + '\'' +
                ", integral='" + integral + '\'' +
                ", sex='" + sex + '\'' +
                ", set_order='" + set_order + '\'' +
                ", get_order='" + get_order + '\'' +
                ", stu_photo='" + stu_photo + '\'' +
                ", iden_photo='" + iden_photo + '\'' +
                ", audit_adm_id='" + audit_adm_id + '\'' +
                ", audit_status='" + audit_status + '\'' +
                '}';
    }

    public String getSet_order() {
        return set_order;
    }

    public void setSet_order(String set_order) {
        this.set_order = set_order;
    }

    public String getGet_order() {
        return get_order;
    }

    public void setGet_order(String get_order) {
        this.get_order = get_order;
    }

    public String getStu_passwd() {
        return stu_passwd;
    }

    public void setStu_passwd(String stu_passwd) {
        this.stu_passwd = stu_passwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStu_nickname() {
        return stu_nickname;
    }

    public void setStu_nickname(String stu_nickname) {
        this.stu_nickname = stu_nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCredibility() {
        return credibility;
    }

    public void setCredibility(String credibility) {
        this.credibility = credibility;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getStu_photo() {
        return stu_photo;
    }

    public void setStu_photo(String stu_photo) {
        this.stu_photo = stu_photo;
    }

    public String getIden_photo() {
        return iden_photo;
    }

    public void setIden_photo(String iden_photo) {
        this.iden_photo = iden_photo;
    }

    public String getAudit_adm_id() {
        return audit_adm_id;
    }

    public void setAudit_adm_id(String audit_adm_id) {
        this.audit_adm_id = audit_adm_id;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
    }
}
