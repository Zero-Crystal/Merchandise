package com.zero.item.controller;

import com.zero.item.entity.Item;

public interface ItemApi {

    /**
     * 查询商品
     *
     * @param id 商品id
     * */
    Item FindItemById(Long id);
}
