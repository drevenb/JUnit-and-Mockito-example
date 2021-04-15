package com.example.mockito;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void jsonPath_test() {
        String response = "[{id:1, name:item1, quantity:5}," +
                            "{id:2, name:item2, quantity:15}," +
                            "{id:3, name:item3, quantity:50}]";

        DocumentContext context = JsonPath.parse(response);

        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1, 2, 3);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='item3')]").toString());
    }
}
