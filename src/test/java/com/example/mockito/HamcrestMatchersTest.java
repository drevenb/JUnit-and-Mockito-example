package com.example.mockito;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 34, 54);

        MatcherAssert.assertThat(numbers, hasSize(3));
        MatcherAssert.assertThat(numbers, hasItems(12, 34));
        MatcherAssert.assertThat(numbers, everyItem(greaterThan(10)));
        MatcherAssert.assertThat(numbers, everyItem(lessThan(100)));

        MatcherAssert.assertThat("", isEmptyString());
        MatcherAssert.assertThat("abcde", containsString("bcd"));
        MatcherAssert.assertThat("abcde", startsWith("abc"));
        MatcherAssert.assertThat("abcde", endsWith("cde"));
    }
}
