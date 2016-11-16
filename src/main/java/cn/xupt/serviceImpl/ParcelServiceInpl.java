package cn.xupt.serviceImpl;

import cn.xupt.entity.Parcel;
import cn.xupt.mapper.ParcelMapper;
import cn.xupt.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/11/14.
 */

@Service
public class ParcelServiceInpl implements ParcelService {

    @Autowired
    private ParcelMapper parcelMapper;

    @Override
    public String parcelPub(Parcel parcel) {
        try {
            parcelMapper.parcelPub(parcel);
        }catch(Exception e){
            return "101";
        }
        return "102";
    }
}
