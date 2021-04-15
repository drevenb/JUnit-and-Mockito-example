package com.example.mockito.service.impl;

import com.example.mockito.model.Item;
import com.example.mockito.repository.ItemRepository;
import com.example.mockito.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getItem() {
        return new Item(1, "Ball", 10.0, 100);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll().stream()
                .map(item -> new Item(item.getId(), item.getName(),
                                        item.getPrice(), item.getQuantity()))
                .collect(Collectors.toList());

        for(Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }
}
