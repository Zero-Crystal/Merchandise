package com.zero.item.services;

import com.zero.item.entity.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Map<Long, Item> itemMap = new HashMap<>();

    static {
        itemMap.put(1l, new Item(1l, "商品1", "http://图片1", "商品描述1", 1000l));
        itemMap.put(2l, new Item(2l, "商品2", "http://图片2", "商品描述2", 2000l));
        itemMap.put(3l, new Item(3l, "商品3", "http://图片3", "商品描述3", 3000l));
        itemMap.put(4l, new Item(4l, "商品4", "http://图片4", "商品描述4", 4000l));
        itemMap.put(5l, new Item(5l, "商品5", "http://图片5", "商品描述5", 5000l));
        itemMap.put(6l, new Item(6l, "商品6", "http://图片6", "商品描述6", 6000l));
        itemMap.put(7l, new Item(7l, "商品7", "http://图片7", "商品描述7", 7000l));
        itemMap.put(8l, new Item(8l, "商品8", "http://图片8", "商品描述8", 8000l));
    }

    /**
     * 获取商品
     * @param id 商品Id
     * @return Item
     * */
    @Override
    public Item findItemById(Long id) {
        return itemMap.get(id);
    }
}
