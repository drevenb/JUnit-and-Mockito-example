package com.example.mockito.service;

import com.example.mockito.model.Item;

import java.util.List;

public interface ItemService {

    Item getItem();

    List<Item> getAllItems();
}
