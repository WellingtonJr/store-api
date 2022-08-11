package com.wellington.storeapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.storeapi.model.Item;
import com.wellington.storeapi.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public Item create(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping("/list")
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/find/{id}")
    public Item findById(@PathVariable("id") UUID id) {
        return itemService.findById(id);
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        itemService.remove(id);
        return "OK";
    }

}
