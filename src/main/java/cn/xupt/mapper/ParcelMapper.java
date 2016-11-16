package cn.xupt.mapper;

import cn.xupt.entity.Parcel;

import java.util.List;

/**
 * Created by Admin on 2016/11/14.
 */
public interface ParcelMapper extends SqlMapper {

    void parcelPub(Parcel parcel);

    List<Parcel> parcelListGet();

}
