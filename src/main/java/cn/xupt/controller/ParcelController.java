package cn.xupt.controller;

import cn.xupt.entity.Parcel;
import cn.xupt.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    private String result;

    @RequestMapping(value = "/{action}",method = RequestMethod.POST)
    public void parcelInfoPublish(@PathVariable String action, HttpServletRequest request, HttpServletResponse response, @ModelAttribute Parcel parcel){
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            switch (action) {
                case "publish":{
                    result = parcelService.parcelPub(parcel);
                    break;
                }
            }



            PrintWriter out = response.getWriter();
            out.write(result);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
