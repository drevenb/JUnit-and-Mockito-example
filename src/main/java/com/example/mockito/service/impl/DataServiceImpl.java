package com.example.mockito.service.impl;

import com.example.mockito.service.DataService;

public class DataServiceImpl implements DataService {

    @Override
    public int[] retriveAllData() {
        return new int[] {1, 2, 3};
    }
}
