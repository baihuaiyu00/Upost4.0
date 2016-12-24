package cn.xupt.service;

import cn.xupt.entity.Order;
import cn.xupt.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2016/12/6.
 */
@Service
public interface OrderService {


    String orderCreate(Order order);

    String orderStatusUpdate(String order_id, String orderStatus);

    String orderInfoGet(String order_id);

    String orderListGet(String type);

    String orderInfoListGet(String stu_id);
}
