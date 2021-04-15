package com.example.mockito.business;

import com.example.mockito.service.DataService;
import com.example.mockito.service.impl.DataServiceImpl;

import java.util.Arrays;

public class BusinessImpl {

    private DataService dataService = new DataServiceImpl();

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(dataService.retriveAllData())
                .reduce(Integer::sum)
                .orElse(0);
    }
}
