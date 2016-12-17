package cn.xupt.service;

import cn.xupt.entity.Order;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/6.
 */
@Service
public interface OrderService {


    String orderCreate(Order order);

    String orderStatusUpdate(String order_id, String orderStatus);

    String orderInfoGet(String order_id);
}
