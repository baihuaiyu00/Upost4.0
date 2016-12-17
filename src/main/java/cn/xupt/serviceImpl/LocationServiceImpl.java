package cn.xupt.serviceImpl;

import cn.xupt.entity.Location;
import cn.xupt.mapper.LocationMapper;
import cn.xupt.service.LocationService;
import cn.xupt.util.JSONCodeUtil;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2016/12/11.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMapper locationMapper;

    /**
     * set the location method
     * @param location user's post data means the location information
     */
    @Override
    public String locationSet(Location location) {
        try {
            locationMapper.locationSet(location);
            return JSONCodeUtil.setJSONCode(102);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * get the locations from set_stu_id
     * @param belong_stu_id user's id
     * @return 101 wrong
     *         List<Location> right return
     */
    @Override
    public String locationGet(String belong_stu_id) {
        try {
            List<Location> locationlist = locationMapper.locationGet(belong_stu_id);
            return JSONCodeUtil.setJSONCode(102,locationlist);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }
}
