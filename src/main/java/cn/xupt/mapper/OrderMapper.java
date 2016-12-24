package cn.xupt.mapper;

import cn.xupt.entity.Order;
import cn.xupt.entity.OrderDetail;
import cn.xupt.entity.Parcel;
import cn.xupt.entity.ParcelInfo;

import java.util.List;

/**
 * Created by Admin on 2016/12/6.
 */
public interface OrderMapper extends SqlMapper{

    void orderCreate(Order order);

    void orderStatusUpdate(String order_id, String orderStatus);

    OrderDetail orderInfoGet(String order_id);

    List<OrderDetail> orderListGet(String type);

    OrderDetail orderInfo(String parcel_id);

    List<ParcelInfo> orderInfoListGet(String stu_id);
}
