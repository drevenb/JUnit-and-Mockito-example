package com.example.mockito.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    private final String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}";

    @Test
    public void jsonAssert_strictTrue() throws JSONException {
        final String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_strictFalse() throws JSONException {
        final String expectedResponse = "{\"id\": 1,\"name\":\"Ball\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_withoutEscapeCharacters() throws JSONException {
        final String expectedResponse = "{id:1,name:Ball}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
