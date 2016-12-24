package cn.xupt.service;

import cn.xupt.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/11/10.
 */
@Service
public interface UserService {

    String userLogin(User user);

    String userRegist(User user);

    String userInfoComplete(String stu_id);

    String userInfoGet(String stu_id);

    String userIdGet(String stu_phone);

    String userIntegralGet(String stu_id);

    String integralListGet();

}
