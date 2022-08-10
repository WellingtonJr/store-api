package com.wellington.storeapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellington.storeapi.model.Item;
import com.wellington.storeapi.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item findById(UUID id) {
        return itemRepository.findById(id).get();
    }

    public void remove(UUID id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        System.out.println(items.size());
        return itemRepository.findAll();
    }

    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

}
