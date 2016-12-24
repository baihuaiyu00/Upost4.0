package cn.xupt.serviceImpl;

import cn.xupt.entity.Admin;
import cn.xupt.entity.User;
import cn.xupt.mapper.AdminMapper;
import cn.xupt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Admin on 2016/12/5.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminLoginMapper;

    /**
     *管理员登录
     * @param admin
     * @return 102 成功登录
     *         100 密码错误
     *         101 管理员名不存在
     */
    public String AdminLogin(Admin admin) {
        String getPwd = adminLoginMapper.adminLogin(admin);
        if(getPwd == null) return "101";
        if(admin.getAdm_passwd().equals(getPwd)){
            return "102";
        }
        return "100";
    }

    @Override
    public void passUser(String stu_num) {
        adminLoginMapper.passUser(stu_num);
    }

    @Override
    public void unpassUser(String stu_num) {
        adminLoginMapper.unpassUser(stu_num);
    }

    @Override
    public ArrayList<User> findUnCheckingUser(int state) {
        ArrayList<User> user = new ArrayList<User>();
        user = adminLoginMapper.findUnCheckingUser(state);
        return user;
    }
}
