package cn.xupt.service;

import cn.xupt.entity.Parcel;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/11/14.
 */

@Service
public interface ParcelService {

    String parcelPub(Parcel parcel);

    String parcelListGet(String sort, String sort_type, String start, String amount);

    String parcelCancel(String parcel_id);

    String parcelInfoGet(String parcel_id);

    String parcelInfoListGet(String stu_id);
}
