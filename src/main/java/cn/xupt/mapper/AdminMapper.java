package cn.xupt.mapper;

import cn.xupt.entity.Admin;

/**
 * Created by Admin on 2016/12/6.
 */
public interface AdminMapper extends SqlMapper{

    String adminLogin(Admin admin);

}
