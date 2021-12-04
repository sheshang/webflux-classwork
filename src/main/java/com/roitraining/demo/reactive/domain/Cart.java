package com.roitraining.demo.reactive.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class Cart {
    Map<Item, Integer> items;
    LocalDate lastUpdatedDate;
}
