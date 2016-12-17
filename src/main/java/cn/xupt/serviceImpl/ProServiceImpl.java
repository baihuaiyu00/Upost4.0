package cn.xupt.serviceImpl;

import cn.xupt.entity.Problem;
import cn.xupt.mapper.ProMapper;
import cn.xupt.service.ProService;
import cn.xupt.util.JSONCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2016/12/17.
 */

@Service
public class ProServiceImpl implements ProService{

    @Autowired
    private ProMapper proMapper;

    @Override
    public String proSubmit(Problem problem) {
        try {
            proMapper.proSubmit(problem);
            return JSONCodeUtil.setJSONCode(102);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    @Override
    public String proDeal(Problem problem) {
        try {
            proMapper.proDeal(problem);
            return JSONCodeUtil.setJSONCode(102);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }

    @Override
    public String proListGet() {
        try {
            List<Problem> proList = proMapper.proListGet();
            System.out.println(proList);
            for(Problem problem:proList){
                System.out.println(problem);
            }
            return JSONCodeUtil.setJSONCode(102,proList);
        }catch(Exception e){
            e.printStackTrace();
            return JSONCodeUtil.setJSONCode(101);
        }
    }
}
