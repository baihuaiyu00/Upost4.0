package cn.xupt.mapper;

import cn.xupt.entity.Admin;
import cn.xupt.entity.User;
import java.util.*;
/**
 * Created by Admin on 2016/12/6.
 */
public interface AdminMapper extends SqlMapper{

    String adminLogin(Admin admin);
    ArrayList<User> findUnCheckingUser(int state);
    void passUser(String stu_num);
    void unpassUser(String stu_num);
}
