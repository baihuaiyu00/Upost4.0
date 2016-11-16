package cn.xupt.controller;

import cn.xupt.entity.User;
import cn.xupt.service.UserService;
import com.alibaba.fastjson.JSON;
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
 * Created by Admin on 2016/11/10.
 */
@Controller
public class UserController {
    private String result;


    @Autowired
    private UserService userService;

    /**
     * depends on the action id,choose the right action
     * to service for user
     *
     * @param request internet request
     * @param response internet response
     * @param action user action from URI
     * @param user User Bean
     * @throws UnsupportedEncodingException ..
     */
        @RequestMapping(value = "/user/{action}",method = RequestMethod.POST)
        public void userAction(HttpServletRequest request, HttpServletResponse response,@PathVariable String action, @ModelAttribute User user) throws UnsupportedEncodingException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                switch (action){
                    case "login":{
                        System.out.println("userLogin::"+user);
                        result = userService.userLogin(user);
                        break;
                    }
                    case "regist":{
                        System.out.println(user);
                        result = userService.userRegist(user);
                        System.out.println("execute regist controller!");
                        break;
                    }
                }
            out.write(result+"");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @RequestMapping(value = "/infoComp/{stu_num}",method=RequestMethod.PUT)
    public void UserInfoUpdate(HttpServletRequest request, HttpServletResponse response,@PathVariable String stu_num,@ModelAttribute User user){
        try {
            request.setCharacterEncoding("utf-8");
            user.setStu_num(stu_num);
            result = userService.userInfoComplete(user);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write(result+"");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
