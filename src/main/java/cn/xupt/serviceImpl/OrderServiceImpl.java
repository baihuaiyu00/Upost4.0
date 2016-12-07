package cn.xupt.serviceImpl;

import cn.xupt.entity.Order;
import cn.xupt.mapper.OrderMapper;
import cn.xupt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 2016/12/6.
 */

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void orderAccept(Order order) {
        Date time = new Date();
        long receive_time = time.getTime();
        order.setReceive_time(receive_time); //上述三行代码为获取当前时间的UNIX时间戳
        orderMapper.orderAccept(order);
    }
}
