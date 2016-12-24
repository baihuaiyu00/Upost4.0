package cn.xupt.controller;

import cn.xupt.entity.Location;
import cn.xupt.entity.User;
import cn.xupt.service.LocationService;
import cn.xupt.service.UserService;
import cn.xupt.util.JSONCodeUtil;
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

/**
 * Created by Admin on 2016/11/10.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;


    /**
     * 用户注册于登录方法的实现
     *
     * @param action 用户执行的动作
     * @param user 用户对象
     * @param request httpRequest
     * @param response httpResponse
     * result 102 操作成功
     *        100 登录：密码错误||服务器报错 注册：服务器错误
     *        101 登录：用户名不存在 注册：服务器错误
     */
    @RequestMapping(value = "/{action}",method = RequestMethod.POST)
    public void userOperation(@PathVariable String action,@ModelAttribute User user,HttpServletRequest request,HttpServletResponse response)
    {
        String result="100";
        switch (action){
            case "login":
                result = userService.userLogin(user);
                break;
            case "regist":
                result = userService.userRegist(user);
                break;
        }
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 用户的信息完善控制器，URI传入用户的手机号，接收的HTTP请求类型为PUT
     * 调用Service中的userInfoComplete方法
     *
     * @param stu_id 以手机号为URI参数
     * @param stu_id
     * @param request 请求对象
     * @param response 响应对象
     */
    @RequestMapping(value = "/{stu_id}/info", method = RequestMethod.PUT)
    public void userInfoComp(@PathVariable String stu_id, HttpServletRequest request, HttpServletResponse response) {
        try {
            String result;
            request.setCharacterEncoding("utf-8");
            // update 2016-12-15
            // 此处需要注意，原来URI参数为stu_phone，后修改为直接传输stu_id；
            // 从传输一整个User对象，修改为传输stu_id字符串
//            user.setStu_id(stu_id);
            System.out.println(stu_id);
            result = userService.userInfoComplete(stu_id);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户信息获取控制器，通过秘钥判断是否权限正确
     * @param stu_id student phone number
     * @param request httprequest
     * @param response httpresponse
     */
    @RequestMapping(value = "/{stu_id}/info",method = RequestMethod.GET)
    public void userInfoGet(@PathVariable String stu_id,HttpServletRequest request,HttpServletResponse response){
        PrintWriter out;
        try{
            out = response.getWriter();
            request.setCharacterEncoding("utf-8");
            String result = userService.userInfoGet(stu_id);
            // update 2016-12-15
            // 此处需要注意，原来URI参数为stu_phone，后修改为直接传输stu_id；
//            String result = userService.userInfoGet(stu_phone);
            out.write(result);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/{stu_id}/integral",method = RequestMethod.GET)
    public void userIntegralGet(@PathVariable String stu_id,HttpServletRequest request,HttpServletResponse response)
    {
        try {
            PrintWriter out = response.getWriter();
            String result = userService.userIntegralGet(stu_id);
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/integral_list",method = RequestMethod.GET)
    public void integralListGet(HttpServletRequest request,HttpServletResponse response){
        try {
            String result = userService.integralListGet();
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * set the location of user
     *
     * @param stu_id user's id in db
     * @param location bean of location
     * @param request http request
     * @param response http response
     */
    @RequestMapping(value = "/{stu_id}/location",method = RequestMethod.POST)
    public void userLocationSet(@PathVariable String stu_id, @ModelAttribute Location location, HttpServletRequest request, HttpServletResponse response){
        try {
            // update 2016-12-15
            // 此处需要注意，原来URI参数为stu_phone，后修改为直接传输stu_id；
//            String user_id = userService.userIdGet(stu_phone);
            //TODO
            //在user_id不存在时的处理方法
            location.setBelong_stu_id(stu_id);
            String result = locationService.locationSet(location);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取对应用户id的地址信息
     * @param stu_id student_id in db
     * @param request httpRequest
     * @param response httpResponse
     */
    @RequestMapping(value = "/{stu_id}/location" ,method = RequestMethod.GET)
    public void userLocationGet(@PathVariable String stu_id,HttpServletRequest request,HttpServletResponse response){
        try {
            // update 2016-12-15
            // 此处需要注意，原来URI参数为stu_phone，后修改为直接传输stu_id；
//            String belong_stu_id = userService.userIdGet(stu_phone);
            String result = locationService.locationGet(stu_id);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

//============================================================================================================
//============                2016-12-16 combine to one method userOperation                        ==========
//============================================================================================================
//    /**
//     * 用户的登录方法，URI传入用户的手机号，接收的HTTP请求类型为POST
//     * 调用Service中的userLogin方法
//     *
//     * @param user user对象中包括值stu_phone、stu_passwd
//     * @param request 请求对象
//     * @param response 响应对象
//     *
//     * result 102 成功登录
//     *        100 密码错误
//     *        101 用户名不存在
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public void userLogin(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response) {
//        try {
//            String result;
//            request.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            result = userService.userLogin(user);
//            out.write(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 用户的注册方法，URI传入用户的手机号，接收的HTTP请求类型为PUT
//     * 调用Service中的userRegist方法
//     *
//     * @param user user对象中包括值stu_phone、stu_passwd
//     * @param request 请求对象
//     * @param response 响应对象
//     */
//    @RequestMapping(value = "/regist", method = RequestMethod.POST)
//    public void userRegist(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response) {
//        try {
//            String result;
//            request.setCharacterEncoding("UTF-8");
////            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            result = userService.userRegist(user);
//            out.write(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//============================================================================================================

