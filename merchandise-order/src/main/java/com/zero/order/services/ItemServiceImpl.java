package com.zero.order.services;

import com.zero.order.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询商品信息
     * @param id
     * */
    @Override
    public Item findItemById(Long id) {
        String itemUrl = "http://merchandise-item/findItem/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        return result;
    }
}
