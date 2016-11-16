package cn.xupt.serviceImpl;

import cn.xupt.entity.User;
import cn.xupt.mapper.UserMapper;
import cn.xupt.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Admin on 2016/11/10.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param user 属性有学号与密码
     * @return 102 成功登录
     *         100 密码错误
     *         101 用户名不存在
     */
    @Override
    public String userLogin(User user) {
        String stu_num = user.getStu_num();
        String password = user.getStu_passwd();
        String find_pwd = userMapper.userLogin(stu_num);

        if(find_pwd==null) return "101";
        if(find_pwd.equals(password)) {
            User new_user = userMapper.userInfoGet(stu_num);
            String jsonString = JSON.toJSONString(new_user);
            return jsonString;
        }else{
            return "100";
        }

    }

    /**
     *
     * @param user 用户注册Bean
     * @return 注册成功 102
     *         注册失败 101
     */
    @Override
    public String userRegist(User user) {
        try {
            userMapper.userRegist(user);
            System.out.println("execute serviceImpl!");
        }catch(Exception e){
            e.printStackTrace();
            return "101";
        }
    return "102";
    }

    /**
     *
     * @param user 用户信息完善
     * @return 102 信息更新成功
     *         101 输入信息有误
     *         103 密码错误
     */
    @Override
    public String userInfoComplete(User user) {
        try{
            String find_pwd = userMapper.userLogin(user.getStu_num());
            if(find_pwd==null) return "100";
            userMapper.userInfoComplete(user);
        }catch(Exception e){
            e.printStackTrace();
            return "101";
        }
        return "102";
    }

}
