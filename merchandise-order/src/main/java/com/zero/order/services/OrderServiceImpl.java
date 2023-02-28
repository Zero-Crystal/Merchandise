package com.zero.order.services;

import com.zero.order.entity.Item;
import com.zero.order.entity.Order;
import com.zero.order.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService{
    private static Map<String, Order> orderMap = new HashMap<>();

    @Autowired
    private ItemServiceImpl itemService;

    static {
        //Order1
        Order order1 = new Order();
        order1.setOrderId("2023022401");
        order1.setCreateDate(new Date());
        order1.setUpdateDate(order1.getCreateDate());
        order1.setUserId(1l);
        List<OrderDetail> orderDetails1 = new ArrayList<>();

        Item item1 = new Item();
        item1.setId(1l);
        orderDetails1.add(new OrderDetail(order1.getOrderId(), item1));

        Item item2 = new Item();
        item2.setId(2l);
        orderDetails1.add(new OrderDetail(order1.getOrderId(), item2));

        order1.setOrderDetails(orderDetails1);
        orderMap.put(order1.getOrderId(), order1);

        //Order2
        Order order2= new Order();
        order2.setOrderId("2023022402");
        order2.setCreateDate(new Date());
        order2.setUpdateDate(order2.getCreateDate());
        order2.setUserId(2l);
        List<OrderDetail> orderDetails2 = new ArrayList<>();

        Item item3 = new Item();
        item3.setId(3l);
        orderDetails2.add(new OrderDetail(order2.getOrderId(), item3));

        Item item4 = new Item();
        item4.setId(4l);
        orderDetails2.add(new OrderDetail(order2.getOrderId(), item4));

        order2.setOrderDetails(orderDetails2);
        orderMap.put(order2.getOrderId(), order2);
    }

    /**
     * 根据订单Id查询订单数据
     *
     * @param id
     * @return Order
     * */
    @Override
    public Order findOrderById(String id) {
        Order order = orderMap.get(id);
        if (order == null) {
            return null;
        }
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            Item item = itemService.findItemById(orderDetail.getItem().getId());
            if (item != null) {
                orderDetail.setItem(item);
            }
        }
        return order;
    }
}
