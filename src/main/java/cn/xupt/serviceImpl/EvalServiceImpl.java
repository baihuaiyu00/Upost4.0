package cn.xupt.serviceImpl;

import cn.xupt.entity.Evaluation;
import cn.xupt.mapper.EvalMapper;
import cn.xupt.service.EvalService;
import cn.xupt.util.JSONCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/17.
 */

@Service
public class EvalServiceImpl implements EvalService {

    @Autowired
    private EvalMapper evalMapper;

    @Override
    public String evalCreate(Evaluation evaluation) {
        try {
            evalMapper.evalCreate(evaluation);
            return JSONCodeUtil.setJSONCode(102);
        }catch(Exception e)
        {
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    @Override
    public String evalGet(String order_id) {
        try {
            Evaluation evaluation = evalMapper.evalGet(order_id);
            return JSONCodeUtil.setJSONCode(102, evaluation);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }
}
