package com.zero.order.controller;

import com.zero.order.entity.Order;

public interface OrderApi {

    Order findOrderById(String id);
}
