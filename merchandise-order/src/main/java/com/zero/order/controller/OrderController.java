package com.zero.order.controller;

import com.zero.order.entity.Order;
import com.zero.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi{

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单信息
     * */
    @Override
    @GetMapping("/findOrder/{orderId}")
    public Order findOrderById(@PathVariable("orderId") String orderId) {
        return orderService.findOrderById(orderId);
    }
}
