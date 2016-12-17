package cn.xupt.controller;

import cn.xupt.entity.Problem;
import cn.xupt.service.ProService;
import cn.xupt.util.JSONCodeUtil;
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
@RequestMapping(value = "/pro")
public class ProController {

    @Autowired
    private ProService proService;

    /**
     *  反馈问题提交接口
     * @param problem 问题内容、问题反馈者
     * @param request httpRequest
     * @param response HTTPResponse
     */
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public void proSubmit(@ModelAttribute Problem problem, HttpServletRequest request, HttpServletResponse response) {
        String result = proService.proSubmit(problem);
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  管理员问题处理接口方法
     * @param problem 问题状态改变
     * @param request httpRequest
     * @param response httpResponse
     */
    @RequestMapping(value = "/deal",method = RequestMethod.PUT)
    public void proDeal(@ModelAttribute Problem problem,HttpServletRequest request,HttpServletResponse response){
        try {
            String result = proService.proDeal(problem);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    /**
     *  管理员问题列表获取接口方法
     * @param request httpRequest
     * @param response httpResponse
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void proListGet(HttpServletRequest request,HttpServletResponse response){
        try {
            String result = proService.proListGet();
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
