package cn.xupt.mapper;

import cn.xupt.entity.Parcel;

import java.util.List;

/**
 * Created by Admin on 2016/11/14.
 */

public interface ParcelMapper extends SqlMapper {

    void parcelPub(Parcel parcel);

    List<Parcel> parcelGet(String set_stu_id);

    List<Parcel> parcelListGet();

    void parcelDel(String parcel_id);

    Parcel parcelInfoGet(String parcel_id);
}
