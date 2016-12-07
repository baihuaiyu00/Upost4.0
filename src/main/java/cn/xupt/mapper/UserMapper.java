package cn.xupt.mapper;

import cn.xupt.entity.User;

import java.util.List;

/**
 * Created by Admin on 2016/11/11.
 */
public interface UserMapper extends SqlMapper {

    String userLogin(String stu_num);

    void userRegist(User user);

    void userInfoComplete(User user);

    User userInfoGet(String stu_num);



}
