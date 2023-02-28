package com.zero.item.controller;

import com.zero.item.entity.Item;
import com.zero.item.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController implements ItemApi{
    @Autowired
    private ItemService itemService;

    @Override
    @GetMapping("/findItem/{id}")
    public Item FindItemById(@PathVariable("id") Long id) {
        return itemService.findItemById(id);
    }
}
