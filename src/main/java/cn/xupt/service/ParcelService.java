package cn.xupt.service;

import cn.xupt.entity.Parcel;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/11/14.
 */

@Service
public interface ParcelService {

    String parcelPub(Parcel parcel);

}