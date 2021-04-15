package com.example.mockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void assertJ_test(){
        List<Integer> numbers = Arrays.asList(12, 34, 54);

        assertThat(numbers).hasSize(3)
                .contains(12, 34)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);

        assertThat("").isEmpty();
        assertThat("abcde").contains("bcd")
                .startsWith("abc")
                .endsWith("cde");
    }
}
