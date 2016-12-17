package cn.xupt.mapper;

import cn.xupt.entity.Problem;

import java.util.List;

/**
 * Created by Admin on 2016/12/17.
 */
public interface ProMapper extends SqlMapper{

    void proSubmit(Problem problem);

    void proDeal(Problem problem);

    List<Problem> proListGet();
}
