package com.example.mockito.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Data
@Table(name = "item")
@NoArgsConstructor
@RequiredArgsConstructor
public class ItemEntity {
    @Id
    @NonNull
    private int id;

    @NonNull
    private String name;

    @NonNull
    private double price;

    @NonNull
    private int quantity;

    @Transient
    private int value;
}
