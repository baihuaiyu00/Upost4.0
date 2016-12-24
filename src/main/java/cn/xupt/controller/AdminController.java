package cn.xupt.controller;

import cn.xupt.entity.Admin;
import cn.xupt.entity.User;
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
import java.util.ArrayList;

/**
 * Created by Admin on 2016/12/5.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/{admin_id}",method = RequestMethod.POST)
    public String  AdminLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Admin admin){
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String result = adminService.AdminLogin(admin);
            out.write(result);

            /**
             * 这块写管理员成功登录后进入的页面
             */
            int state = 0; //待审核，-1代表拒绝，1代表通过。
            ArrayList<User> userlist = new ArrayList<User>();
            userlist = adminService.findUnCheckingUser(state);
            request.setAttribute("userlist",userlist);
            return "admin";
        } catch (IOException e) {
            e.printStackTrace();
            return "index";
        }
    }
    @RequestMapping(value = "/pass",method = RequestMethod.GET)
    public String pass(HttpServletRequest request, HttpServletResponse response){
        String stu_num = request.getParameter("stu_num");
        adminService.passUser(stu_num);
        int state = 0; //待审核，-1代表拒绝，1代表通过。
        ArrayList<User> userlist = new ArrayList<User>();
        userlist = adminService.findUnCheckingUser(state);
        request.setAttribute("userlist",userlist);
        return "admin";
    }

    @RequestMapping(value = "/unpass",method = RequestMethod.GET)
    public String unpass(HttpServletRequest request, HttpServletResponse response){
        String stu_num = request.getParameter("stu_num");
        adminService.unpassUser(stu_num);
        int state = 0; //待审核，-1代表拒绝，1代表通过。
        ArrayList<User> userlist = new ArrayList<User>();
        userlist = adminService.findUnCheckingUser(state);
        request.setAttribute("userlist",userlist);
        return "admin";
    }
}
