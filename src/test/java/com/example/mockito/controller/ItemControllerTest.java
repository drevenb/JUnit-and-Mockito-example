package com.example.mockito.controller;

import com.example.mockito.model.Item;
import com.example.mockito.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void getItem_basic() throws Exception {
        final String expectedJson = "{id:1, name:Ball, price:10.0}";
        //call GET
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andReturn();

        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getItem_withService() throws Exception {
        final String expectedJson = "{id:2, name:item2, price:10.0}";
        when(itemService.getItem())
                .thenReturn(new Item(2, "item2", 10.0, 12));

        //call GET
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andReturn();

        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getItems_fromDatabase() throws Exception {
        final String expectedJson = "[{id:2, name:item2, price:10.0}," +
                                     "{}]";

        when(itemService.getAllItems())
                .thenReturn(Arrays.asList(new Item(2, "item2", 10.0, 50),
                                            new Item(3, "item3", 20.0, 150)));

        //call GET
        RequestBuilder request = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andReturn();

        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
