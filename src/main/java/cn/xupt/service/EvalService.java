package cn.xupt.service;

import cn.xupt.entity.Evaluation;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/17.
 */

@Service
public interface EvalService {

    String evalCreate(Evaluation evaluation);

    String evalGet(String order_id);
}
