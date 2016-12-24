package cn.xupt.serviceImpl;

import cn.xupt.entity.Integral;
import cn.xupt.entity.User;
import cn.xupt.mapper.UserMapper;
import cn.xupt.service.UserService;
import cn.xupt.util.JSONCodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2016/11/10.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *用户登录
     *
     * @param user 属性有手机号与密码
     * @return 102 data 成功登录
     *         100 密码错误
     *         101 用户名不存在
     */
    @Override
    public String userLogin(User user) {
        String stu_phone = user.getStu_phone();
        String password = user.getStu_passwd();
        String find_pwd = userMapper.userLogin(stu_phone); //通过电话号码取得用户密码

        if(find_pwd==null) return JSONCodeUtil.setJSONCode(101); // not exist

        if(find_pwd.equals(password)) {
            //return the User
            User new_user = userMapper.userInfoGetByPn(stu_phone);
            System.out.println(new_user);
            return JSONCodeUtil.setJSONCode(102,new_user);

        }else{// wrong password
            return JSONCodeUtil.setJSONCode(100);
        }

    }

    /**
     * 注册成功后返回一定需要的默认信息
     * @param user 用户注册Bean
     * @return 注册成功 102
     *         注册失败 101
     */
    @Override
    public String userRegist(User user) {
        try {
            userMapper.userRegist(user);
            System.out.println("execute regist serviceImpl!");
            user.setStu_id(userMapper.userIdGet(user.getStu_phone()));
            user.setStu_passwd(null);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
        //TODO
//        注册成功是否返回一个"默认"的用户信息
    return JSONCodeUtil.setJSONCode(102,user);
    }

    /**
     *
     * @param stu_id 用户信息完善
     * @return 102 信息更新成功
     *         101 输入信息有误
     *         103 密码错误
     */
    @Override
    public String userInfoComplete(String stu_id) {
        try{
            userMapper.userInfoComplete(stu_id);
            System.out.println("success");
            User return_user = userMapper.userInfoGet(stu_id);
            return JSONCodeUtil.setJSONCode(102,return_user);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("failed");
            return JSONCodeUtil.setJSONCode(101);

        }

    }

    /**
     * get user infomation
     * @param stu_id
     * @return User user right success
     *          101 wrong
     */
    @Override
    public String userInfoGet(String stu_id) {
        try {
            User user = userMapper.userInfoGet(stu_id);
            if(user == null)
                return JSONCodeUtil.setJSONCode(101);
            return JSONCodeUtil.setJSONCode(102,user);
        }catch(Exception e ){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * get the user's stu_id from stu_phone
     * @param stu_phone user's phone number
     * @return 101 wrong
     */
    @Override
    public String userIdGet(String stu_phone) {
        try {
            String stu_id = userMapper.userIdGet(stu_phone);
            return stu_id;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param stu_id
     * @return 100 not exist 101 error 102 success
     */
    @Override
    public String userIntegralGet(String stu_id) {
        try {
            String integral = userMapper.userIntegralGet(stu_id);
            JSONObject obj = new JSONObject();
            obj.put("integral",integral);
            if (integral == null)
                return JSONCodeUtil.setJSONCode(100);
            return JSONCodeUtil.setJSONCode(102, obj);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    @Override
    public String integralListGet() {
        try {
            List<Integral> list = userMapper.integralListGet();
            if (list == null)
                return JSONCodeUtil.setJSONCode(101);
            return JSONCodeUtil.setJSONCode(102, list);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

}
