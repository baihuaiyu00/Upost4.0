package cn.xupt.service;

import cn.xupt.entity.Order;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/6.
 */
@Service
public interface OrderService {

    void orderAccept(Order order);

}
