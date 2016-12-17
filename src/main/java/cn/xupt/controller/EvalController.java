package cn.xupt.controller;

import cn.xupt.entity.Evaluation;
import cn.xupt.service.EvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Admin on 2016/12/17.
 */
@Controller
@RequestMapping(value = "/eval")
public class EvalController {

    @Autowired
    private EvalService evalService;

    /**
     * 用户订单评价接口方法
     * @param evaluation POST过来的评价相关参数封装成对象
     * @param request httpRequest
     * @param response
     */
    @RequestMapping(value = "/{order_id}/eval",method = RequestMethod.POST)
    public void evalCreate(@PathVariable String order_id, @ModelAttribute Evaluation evaluation, HttpServletRequest request, HttpServletResponse response){
        try {
            evaluation.setBelong_order_id(order_id);
            String result = evalService.evalCreate(evaluation);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 方法为获取对应订单号的评价信息
     * @param order_id 对应的订单号
     * @param request httpRequest
     * @param response httpResponse
     */
    @RequestMapping(value = "/{order_id}/eval",method = RequestMethod.GET)
    public void orderEvalGet(@PathVariable String order_id,HttpServletRequest request,HttpServletResponse response){
        try {
            String result = evalService.evalGet(order_id);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
