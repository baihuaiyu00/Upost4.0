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
     * @param parcel_id
     * @param request
     * @param response
     * @param parcel
     * 需要传入的Bean中携带信息为：
     * 快递公司（company），取件时间（？），发布人联系方式（通过set_stu_id获取联系方式？）
     * 重量（weight），快递猿送件时间（？），快递猿送件地址（location_2_id）
     * 物品类型（type），打赏小费（reward）
     */
    @RequestMapping(value = "/{parcel_id}",method = RequestMethod.POST)
    public void parcelInfoPublish(@PathVariable String parcel_id, HttpServletRequest request, HttpServletResponse response, @ModelAttribute Parcel parcel){
        try {
            System.out.println("kidding me?");
            String result;
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            result = parcelService.parcelPub(parcel);
            PrintWriter out = response.getWriter();
            out.write(result);
            DispatcherServlet;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
