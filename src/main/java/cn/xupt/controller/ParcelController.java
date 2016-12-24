package cn.xupt.controller;

import cn.xupt.entity.Parcel;
import cn.xupt.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 2016/11/14.
 */

@Controller
@RequestMapping("/parcel")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;
    /**
     *
     * @param request httpRequest
     * @param response httpResponse
     * @param parcel
     * 需要传入的Bean中携带信息为：
     * 快递公司（company），取件时间（？），发布人联系方式（通过set_stu_id获取联系方式？）
     * 重量（weight），快递猿送件时间（？），快递猿送件地址（location_2_id）
     * 物品类型（type），打赏小费（reward）
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void parcelInfoPublish(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Parcel parcel){
        try {
            String result;
            request.setCharacterEncoding("utf-8");
            result = parcelService.parcelPub(parcel);
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  获取发布好的订单列表展示信息供包裹侠抢单
     *
     *  “抢单”页面显示的信息
     *
     * @param request httpRequest
     * @param response HttpResponse
     *
     *                 需要四个参数：sort：排序的索引项
     *                             sort_type：正序或者倒序
     *                             start：从第几项开始返回
     *                             amount：返回多少条记录
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public void parcelListGet(HttpServletRequest request,HttpServletResponse response){
        try {
            //
            String a,b,c,d;
            String result,sort = "parcel_id",sort_type = "desc",start = "0",amount = "10";
            if((a = request.getParameter("sort"))!=null)
                sort = a;
            if((b = request.getParameter("sort_type"))!=null)
                sort_type = b;
            if((c = request.getParameter("start"))!=null)
                start = c;
            if((d = request.getParameter("amount"))!=null)
                amount = d;

            result = parcelService.parcelListGet(sort,sort_type,start,amount);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  撤销订单方法控制器
     * @param parcel_id
     * @param request
     * @param response
     */
    @RequestMapping(value = "/{parcel_id}",method = RequestMethod.DELETE)
    public void parcelCancel(@PathVariable String parcel_id,HttpServletRequest request,HttpServletResponse response){
//        request.setCharacterEncoding();
        try {
            String result;
            result = parcelService.parcelCancel(parcel_id);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 此接口原本准备用于接单后详细信息的返回，但是现在准备在Order里面写，所以暂时不用！！！！！！！！
     * @param request
     * @param response
     */
//    @RequestMapping(value = "/{parcel_id}",method = RequestMethod.GET)
//    public void parcelInfoGet(@PathVariable String parcel_id,HttpServletRequest request,HttpServletResponse response){
//        try {
//            String result;
//            result = parcelService.parcelInfoGet(parcel_id);
//            PrintWriter out = response.getWriter();
//            out.write(result);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    /**
     * 查看自己发布的订单信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/infolist/{stu_id}",method = RequestMethod.GET)
    public void parcelInfoList(@PathVariable String stu_id,HttpServletRequest request,HttpServletResponse response){
        try {
            String result = parcelService.parcelInfoListGet(stu_id);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
