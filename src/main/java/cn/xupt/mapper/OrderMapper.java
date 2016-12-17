package cn.xupt.mapper;

import cn.xupt.entity.Order;
import cn.xupt.entity.OrderDetail;
import cn.xupt.entity.Parcel;

/**
 * Created by Admin on 2016/12/6.
 */
public interface OrderMapper extends SqlMapper{

    void orderCreate(Order order);

    void orderStatusUpdate(String order_id, String orderStatus);

    OrderDetail orderInfoGet(String order_id);
}
