package cn.xupt.controller;

import cn.xupt.entity.Order;
import cn.xupt.service.OrderService;
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
import java.util.Date;

/**
 * Created by Admin on 2016/12/6.
 */

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @RequestMapping(value = "/{order_id}",method = RequestMethod.PUT)
//    public void orderAccept(@PathVariable String order_id, HttpServletRequest request, HttpServletResponse response, @ModelAttribute Order order){
//
//    }

    /**
     * 订单生成方法
     * @param order
     * @param request
     * @param response
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void orderCreate(@ModelAttribute Order order,HttpServletRequest request,HttpServletResponse response){
        try {
            String result = orderService.orderCreate(order);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param action 订单的状态更改动作
     * @param order_id 订单的ID
     * @param request HttpRequest
     * @param response HttpResponse
     */
    @RequestMapping(value = "/{order_id}",method = RequestMethod.PUT,params = "action")
    public void orderStatusUpdate(String action,@PathVariable String order_id,HttpServletRequest request,HttpServletResponse response)
    {
        String result_code = JSONCodeUtil.setJSONCode(100);
        try {
            PrintWriter out = response.getWriter();

            switch (action) {
                case "signed":
                    result_code = orderService.orderStatusUpdate(order_id, "0");
                    break;
                case "given":
                    result_code = orderService.orderStatusUpdate(order_id, "1");
                    break;
                case "paid":
                    result_code = orderService.orderStatusUpdate(order_id, "2");
                    break;
            }
            out.write(result_code);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{order_id}",method = RequestMethod.GET)
    public void orderInfoGet(@PathVariable String order_id,HttpServletRequest request,HttpServletResponse response)
    {
        try {
            String result;
            result = orderService.orderInfoGet(order_id);
            PrintWriter out = response.getWriter();
            out.write(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
