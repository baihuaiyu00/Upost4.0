package cn.xupt.service;

import cn.xupt.entity.Location;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/11.
 */
@Service
public interface LocationService {

    String locationSet(Location location);

    String locationGet(String belong_stu_id);
}
