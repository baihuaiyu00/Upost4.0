package cn.xupt.serviceImpl;

import cn.xupt.entity.Order;
import cn.xupt.entity.OrderDetail;
import cn.xupt.mapper.OrderMapper;
import cn.xupt.service.OrderService;
import cn.xupt.util.JSONCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Admin on 2016/12/6.
 */

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;




    /**
     *  快递猿接单后生成订单实现
     * @param order 订单对象
     * @return 101 失败
     *         102 成功
     */
    @Override
        public String orderCreate(Order order) {
        try {
//            String user_id = parcel.getSet_stu_id();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");
            Date d = new Date();
            String create_id = sdf.format(d)+order.getGet_stu_id();
//            parcel.setParcel_id(create_id);  // set the parcel_id from user_id append to create_daytime
            order.setOrder_id(create_id); //生成订单ID

            order.setOrder_status("-1"); //设置订单目前状态
            orderMapper.orderCreate(order);
            return JSONCodeUtil.setJSONCode(102,order);
        }catch(Exception e ){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * 订单状态改变方法
     * @param order_id
     * @param orderStatus
     */
    @Override
    public String orderStatusUpdate(String order_id, String orderStatus) {
        try{
            orderMapper.orderStatusUpdate(order_id,orderStatus);
            return JSONCodeUtil.setJSONCode(102);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * 订单详细信息获取接口实现
     * @param order_id
     * @return
     */
    @Override
    public String orderInfoGet(String order_id) {
        try {
            OrderDetail orderDetail = orderMapper.orderInfoGet(order_id);
            return JSONCodeUtil.setJSONCode(102, orderDetail);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }
}
