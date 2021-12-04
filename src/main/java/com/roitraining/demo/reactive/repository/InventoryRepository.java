package com.roitraining.demo.reactive.repository;

import com.roitraining.demo.reactive.domain.Item;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class InventoryRepository {

    public Flux<Item> getItems() {
        return Flux.just(new Item("food"), new Item("drink"), new Item("household"), new Item("fashion"));
    }
}
