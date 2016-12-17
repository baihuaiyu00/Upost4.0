package cn.xupt.mapper;

import cn.xupt.entity.Location;

import java.util.List;

/**
 * Created by Admin on 2016/12/11.
 */
public interface LocationMapper extends SqlMapper{

    void locationSet(Location location);

    List<Location> locationGet(String belong_stu_id);
}
