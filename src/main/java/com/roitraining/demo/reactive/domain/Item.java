package com.roitraining.demo.reactive.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    long itemId;
    String category;
    double price;
    int discountRate;
    String name;

    public Item(String cat) {
        this.category = cat;
    }
}
