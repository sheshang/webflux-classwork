package com.roitraining.demo.reactive.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class Inventory {
    Map<Item, Integer> items;
    List<Order> orders;
    Map<Item, Integer> itemsTobeReFilled;
    LocalDate lastDateInventoryRefilled;
}
