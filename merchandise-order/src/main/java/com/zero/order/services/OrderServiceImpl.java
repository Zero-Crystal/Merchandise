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
        Order order = new Order();
        order.setOrderId("2023022401");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1l);
        List<OrderDetail> orderDetails = new ArrayList<>();

        Item item1 = new Item();
        item1.setId(1l);
        orderDetails.add(new OrderDetail(order.getOrderId(), item1));

        Item item2 = new Item();
        item2.setId(2l);
        orderDetails.add(new OrderDetail(order.getOrderId(), item2));

        order.setOrderDetails(orderDetails);

        orderMap.put(order.getOrderId(), order);
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
