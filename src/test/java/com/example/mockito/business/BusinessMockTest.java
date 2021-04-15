package com.example.mockito.business;

import com.example.mockito.service.DataService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusinessMockTest {

    @InjectMocks
    BusinessImpl business;

    @Mock
    DataService dataService;

    @Test
    public void calculate_sum_using_DataService_basic() {
        Mockito.when(dataService.retriveAllData()).thenReturn(new int[] {1, 2, 3});
        Assertions.assertEquals(6, business.calculateSumUsingDataService());
    }
}
