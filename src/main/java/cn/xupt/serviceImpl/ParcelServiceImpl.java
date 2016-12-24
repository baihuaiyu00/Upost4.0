package cn.xupt.serviceImpl;

import cn.xupt.entity.OrderDetail;
import cn.xupt.entity.Parcel;
import cn.xupt.entity.ParcelInfo;
import cn.xupt.mapper.OrderMapper;
import cn.xupt.mapper.ParcelMapper;
import cn.xupt.mapper.UserMapper;
import cn.xupt.service.ParcelService;
import cn.xupt.util.JSONCodeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2016/11/14.
 */

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelMapper parcelMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 订单发布实现，发布成功后返回本人订单列表
     *
     * @param parcel 订单相关信息
     * @return 101 错误
     *         102 成功发布包裹信息
     */
    @Override
    public String parcelPub(Parcel parcel) {
        try {
//            String user_id = parcel.getSet_stu_id();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");
//            Date d = new Date();
//            String create_id = sdf.format(d)+user_id;
//            parcel.setParcel_id(create_id);  // set the parcel_id from user_id append to create_daytime

            parcelMapper.parcelPub(parcel);
            List<Parcel> parcel_list = parcelMapper.parcelGet(parcel.getSet_stu_id());
//            String result = orderMapper.orderCreate(parcel);
            return JSONCodeUtil.setJSONCode(102,parcel_list);

        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }

    }

    /**
     * 由于此处的形式比较特别，stu_name要再次查询数据库才能获得，
     * 所以并没有完全使用工具类，而是分别封装result_code与data两个JSON对象，
     *再把两个JSON对象封装进一个JSON对象中
     * @return
     * @param sort
     * @param sort_type
     * @param start
     * @param amount
     */
    @Override
    public String parcelListGet(String sort, String sort_type, String start, String amount) {
        try {
            start = String.valueOf(Integer.valueOf(start)-1 );
            List<Parcel> parcellist = parcelMapper.parcelListGet(sort,sort_type,start,amount);
            JSONObject json = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (Parcel p : parcellist) {
                JSONObject jsons = new JSONObject();
                String stu_name = userMapper.userNameGet(p.getSet_stu_id());
                jsons.put("parcel_id",p.getParcel_id());
                jsons.put("stu_name", stu_name);
                jsons.put("location_1", p.getLocation_1());
                jsons.put("location_2", p.getLocation_2());
                jsons.put("reward", p.getReward());
//                jsons.put("size", p.getSize());
                jsons.put("urgent", p.getUrgent());
                jsons.put("start_time",p.getStart_time());
                jsons.put("end_time",p.getEnd_time());
                jsons.put("note",p.getNote());
                System.out.println(jsons);
                jsonArray.add(jsons);
            }
            json.put("result_code", "102");
            json.put("data", jsonArray);
            return String.valueOf(json);
        }catch(Exception e ){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * 订单撤销方法
     * @param parcel_id 订单ID
     * @return 102 成功撤销
     *         101 撤销失败
     */
    @Override
    public String parcelCancel(String parcel_id) {
        try {
            parcelMapper.parcelDel(parcel_id);
            return JSONCodeUtil.setJSONCode(102);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * 快递猿抢到订单后返回给他的详细信息接口
     * @param parcel_id
     * @return
     */
    @Override
    public String parcelInfoGet(String parcel_id) {
        try {
            Parcel parcel_got = parcelMapper.parcelInfoGet(parcel_id);
            return JSONCodeUtil.setJSONCode(102, parcel_got);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    /**
     * check the parcel infomation list
     * @param stu_id
     * @return
     */
    @Override
    public String parcelInfoListGet(String stu_id) {
        try {
            List<ParcelInfo> list = parcelMapper.parcelInfoListGet(stu_id);
            JSONObject object = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (ParcelInfo info : list) {
                System.out.println(info);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("parcel_id", info.getParcel_id());
                jsonObject.put("location_1", info.getLocation_1());
                jsonObject.put("location_2", info.getLocation_2());
                jsonObject.put("create_time", info.getCreate_time());
                jsonObject.put("start_time", info.getStart_time());
                jsonObject.put("end_time", info.getEnd_time());
                if ("0".equals(info.getPar_status())) {
                    OrderDetail orderDetail = orderMapper.orderInfo(info.getParcel_id());
                    jsonObject.put("receive_time", orderDetail.getReceive_time());
                    jsonObject.put("status", orderDetail.getOrder_status());
                } else {
                    jsonObject.put("status", "-2");
                }
                System.out.println(jsonObject);
                System.out.println("---------------------------------------------------------------------------");
                jsonArray.add(jsonObject);
            }
            object.put("result_code", "102");
            object.put("data", jsonArray);
            return String.valueOf(object);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

}
