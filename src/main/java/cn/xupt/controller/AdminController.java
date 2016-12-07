package cn.xupt.controller;

import cn.xupt.entity.Admin;
import cn.xupt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 2016/12/5.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/{admin_id}",method = RequestMethod.POST)
    public void AdminLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Admin admin){
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String result = adminService.AdminLogin(admin);
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
