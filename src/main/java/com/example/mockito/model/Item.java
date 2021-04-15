package com.example.mockito.model;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {
    @NonNull
    private int id;

    @NonNull
    private String name;

    @NonNull
    private double price;

    @NonNull
    private int quantity;

    private double value;
}
