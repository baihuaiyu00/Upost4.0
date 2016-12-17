package cn.xupt.mapper;

import cn.xupt.entity.User;

import java.util.List;

/**
 * Created by Admin on 2016/11/11.
 */
public interface UserMapper extends SqlMapper {

    String userLogin(String stu_phone);

    void userRegist(User user);

    void userInfoComplete(String stu_id);

    User userInfoGet(String stu_id);

    User userInfoGetByPn(String stu_phone);

    String userIdGet(String stu_phone);

    String userNameGet(String stu_id);
}
