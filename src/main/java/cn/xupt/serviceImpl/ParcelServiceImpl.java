package cn.xupt.serviceImpl;

import cn.xupt.entity.Parcel;
import cn.xupt.mapper.OrderMapper;
import cn.xupt.mapper.ParcelMapper;
import cn.xupt.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/11/14.
 */

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelMapper parcelMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     *
     * @param parcel
     * @return 101 错误
     *         102 成功发布包裹信息
     */
    @Override
    public String parcelPub(Parcel parcel) {
        try {
            parcelMapper.parcelPub(parcel);
            String result = orderMapper.orderCreate(parcel);
        }catch(Exception e){
            e.printStackTrace();
            return "101";
        }
        return "102";
    }
}
