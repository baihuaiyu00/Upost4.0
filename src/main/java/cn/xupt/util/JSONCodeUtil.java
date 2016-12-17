package cn.xupt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Admin on 2016/12/11.
 */
public class JSONCodeUtil {

    public static String setJSONCode(int result){
        JSONObject json = new JSONObject();
        json.put("result_code",String.valueOf(result));
        json.put("data","null");
        return json.toJSONString();
    }

    public static String setJSONCode(int result,Object object){
        JSONObject json = new JSONObject();
        json.put("data", object);
        json.put("result_code",String.valueOf(result));
        return String.valueOf(json);
    }

    public static String setJSONCode(int result, List<Object> list){
        JSONObject json = new JSONObject();
        json.put("result_code",String.valueOf(result));

        JSONArray jsonArray = new JSONArray();
        for(Object o:list){
            jsonArray.add(o);
        }
        json.put("data",jsonArray);
        return String.valueOf(json);
    }



}
