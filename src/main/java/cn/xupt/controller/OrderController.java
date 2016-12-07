package cn.xupt.controller;

import cn.xupt.entity.Order;
import cn.xupt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Admin on 2016/12/6.
 */

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{order_id}",method = RequestMethod.PUT)
    public void orderAccept(@PathVariable String order_id, HttpServletRequest request, HttpServletResponse response, @ModelAttribute Order order){



    }

}
