package cn.xupt.serviceImpl;

import cn.xupt.entity.Order;
import cn.xupt.entity.OrderDetail;
import cn.xupt.entity.ParcelInfo;
import cn.xupt.mapper.OrderMapper;
import cn.xupt.mapper.ParcelMapper;
import cn.xupt.mapper.UserMapper;
import cn.xupt.service.OrderService;
import cn.xupt.util.JSONCodeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2016/12/6.
 */

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ParcelMapper parcelMapper;


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
            String par_status = "0";
            parcelMapper.parcelStatusSet(par_status,order.getParcel_id());
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
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("order_id",orderDetail.getOrder_id());
            jsonObject.put("create_time",orderDetail.getCreate_time());
            jsonObject.put("start_time",orderDetail.getStart_time());
            jsonObject.put("end_time",orderDetail.getEnd_time());
            jsonObject.put("take_name",orderDetail.getTake_name());
            jsonObject.put("take_phone",orderDetail.getTake_phone());
            jsonObject.put("location_1",orderDetail.getLocation_1());
            jsonObject.put("location_2",orderDetail.getLocation_2());
            jsonObject.put("reward",orderDetail.getReward());
            jsonObject.put("size",orderDetail.getSize());
            String get_stu_nickname = userMapper.userNicknameGet(orderDetail.getGet_stu_id());
            String set_stu_nickname = userMapper.userNicknameGet(orderDetail.getSet_stu_id());
            jsonObject.put("set_stu_nickname",get_stu_nickname);
            jsonObject.put("set_stu_nickname",set_stu_nickname);
            return JSONCodeUtil.setJSONCode(102, jsonObject);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    @Override
    public String orderListGet(String type) {
        try {
            List<OrderDetail> list = orderMapper.orderListGet(type);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (OrderDetail orderDetail : list) {
                jsonObject.put("order_id", orderDetail.getOrder_id());
                jsonObject.put("receive_time", orderDetail.getReceive_time());
                jsonObject.put("take_name", orderDetail.getTake_name());
                jsonObject.put("take_phone", orderDetail.getTake_phone());
                jsonObject.put("location_1", orderDetail.getLocation_1());
                jsonObject.put("location_2", orderDetail.getLocation_2());
                jsonObject.put("type", orderDetail.getType());
                jsonObject.put("reward", orderDetail.getReward());
                jsonObject.put("create_time", orderDetail.getCreate_time());
                jsonObject.put("size", orderDetail.getSize());
                jsonObject.put("urgent", orderDetail.getUrgent());
                jsonObject.put("start_time", orderDetail.getStart_time());
                jsonObject.put("end_time", orderDetail.getEnd_time());
                jsonObject.put("note", orderDetail.getNote());
                String set_stu_nickname = userMapper.userNicknameGet(orderDetail.getSet_stu_id());
                String get_stu_nickname = userMapper.userNicknameGet(orderDetail.getGet_stu_id());
                jsonObject.put("set_stu_nickname", set_stu_nickname);
                jsonObject.put("get_stu_nickname", get_stu_nickname);
                jsonArray.add(jsonObject);
            }
            return JSONCodeUtil.setJSONCode(102, jsonArray);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * 查看自己抢单信息
     * @param stu_id
     * @return
     */
    @Override
    public String orderInfoListGet(String stu_id) {
        try {
            List<ParcelInfo> list = orderMapper.orderInfoListGet(stu_id);
            JSONArray jsonArray = new JSONArray();
            for (ParcelInfo info : list) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("parcel_id", info.getParcel_id());
                jsonObject.put("order_id", info.getOrder_id());
                jsonObject.put("location_1", info.getLocation_1());
                jsonObject.put("location_2", info.getLocation_2());
                jsonObject.put("create_time", info.getCreate_time());
                jsonObject.put("start_time", info.getStart_time());
                jsonObject.put("end_time", info.getEnd_time());
                jsonObject.put("receive_time", info.getReceive_time());
                jsonObject.put("status", info.getOrder_status());
                jsonArray.add(jsonObject);
            }
            return JSONCodeUtil.setJSONCode(102, jsonArray);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }
}
