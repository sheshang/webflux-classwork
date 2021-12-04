package com.roitraining.demo.reactive.service;

import com.roitraining.demo.reactive.domain.Item;
import com.roitraining.demo.reactive.repository.InventoryRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository invRepo) {
        this.inventoryRepository = invRepo;
    }

    public Flux<Item> getItems() {
        return Flux.interval(Duration.ofSeconds(1))
                .take(10)
                .map(s -> new Item());
    }

    public Flux<Item> getItems(String category) {
        return this.inventoryRepository.getItems()
                .filter(i -> i.getCategory().equals(category));
    }
}
