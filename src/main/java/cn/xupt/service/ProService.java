package cn.xupt.service;

import cn.xupt.entity.Problem;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/12/17.
 */
@Service
public interface ProService {

    String proSubmit(Problem problem);

    String proDeal(Problem problem);

    String proListGet();

}
