package com.example.mockito.business;

import com.example.mockito.entity.ItemEntity;
import com.example.mockito.model.Item;
import com.example.mockito.repository.ItemRepository;
import com.example.mockito.service.impl.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void calculate_sum_using_DataService_basic() {


        Mockito.when(itemRepository.findAll())
                .thenReturn(Arrays.asList(new ItemEntity(2, "item2", 10.0, 50),
                                            new ItemEntity(3, "item3", 20.0, 150)));

        List<Item> items = itemService.getAllItems();
        assertEquals(500, items.get(0).getValue());
        assertEquals(3000, items.get(1).getValue());
    }
}
