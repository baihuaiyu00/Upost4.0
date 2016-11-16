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

    String userInfoComplete(User user);

}
