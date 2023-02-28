package com.zero.order.services;

import com.zero.order.entity.Order;

public interface OrderService {

    Order findOrderById(String id);
}
