package com.roitraining.demo.reactive.domain;

import com.roitraining.demo.reactive.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class Order {
    long orderId;
    List<Item> items;
    double totalPrice;
    LocalDate orderDate;
    LocalDate deliveryDate;
    OrderStatus status;
    String billingId;
    UUID accountId;
    String shippingAddress;
}
