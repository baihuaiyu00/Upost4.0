package cn.xupt.service;

import cn.xupt.entity.Admin;
import cn.xupt.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Admin on 2016/12/5.
 */

@Service
public interface AdminService {

    String AdminLogin(Admin admin);

    ArrayList<User> findUnCheckingUser(int state);

    void passUser(String stu_num);

    void unpassUser(String stu_num);
}
