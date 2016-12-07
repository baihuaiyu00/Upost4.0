package cn.xupt.mapper;

import cn.xupt.entity.Order;
import cn.xupt.entity.Parcel;

/**
 * Created by Admin on 2016/12/6.
 */
public interface OrderMapper extends SqlMapper{

    String orderCreate(Parcel parcel);

    void orderAccept(Order order);
}
