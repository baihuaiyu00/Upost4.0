package cn.xupt.service;

import cn.xupt.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/5.
 */

@Service
public interface AdminService {

    String AdminLogin(Admin admin);

}
