package cn.xupt.controller;

import cn.xupt.entity.Location;
import cn.xupt.util.JSONCodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/12/11.
 */
public class ControllerTest {

    public static void main(String[] args){
        String a = "102";
        a = String.valueOf(Integer.valueOf(a)+1);
        System.out.println(a);

//        String result = "102";
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("result_code",result);
//        System.out.println(jsonObject);

//        JSONObject o = new JSONObject();
//        o.put("result_code","102");
//        Location l1 = new Location("1","2","3","5");
//        Location l2 = new Location("1","2","3","5");
//        Location l3 = new Location("1","2","3","5");
//        List<Location> locationlist = new ArrayList<Location>();
//        locationlist.add(l1);
//        locationlist.add(l2);
//        locationlist.add(l3);
//        JSONCodeUtil.setJSONCode(102,locationlist);
//        JSONArray jsonArray = new JSONArray();
//        for(Location location:locationlist){
//            jsonArray.add(location);
//        }
//        o.put("data",jsonArray);
//        System.out.println(String.valueOf(o));
//        System.out.println(JSONCodeUtil.setJSONCode(102,locationlist));
    }

}
