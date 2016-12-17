package cn.xupt.mapper;

import cn.xupt.entity.Evaluation;

/**
 * Created by Admin on 2016/12/17.
 */
public interface EvalMapper extends SqlMapper{

    void evalCreate(Evaluation evaluation);

    Evaluation evalGet(String order_id);
}
