package com.example.mockito.controller;

import com.example.mockito.model.Item;
import com.example.mockito.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item")
    public ResponseEntity<Item> getItem() {
        Item item = new Item(1, "Ball", 10.0, 100);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/item-service")
    public ResponseEntity<Item> getItemWithService() {
        return new ResponseEntity<>(itemService.getItem(), HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }
}
