package com.roitraining.demo.reactive.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table
public class Account {
    @Id
    UUID accountId;
    String accountOwnerName;
//    Cart cart;
//    List<Order> orders;
    Double walletAmount;
    int rewardPoints;

    public Account() {
        this.accountId = UUID.randomUUID();
    }
}
