package com.roitraining.demo.reactive.handler;

import com.roitraining.demo.reactive.domain.Item;
import com.roitraining.demo.reactive.service.InventoryService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InventoryHandler {

    private final InventoryService inventoryService;

    public InventoryHandler(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Mono<ServerResponse> getItems(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(inventoryService.getItems(), Item.class);
    }

    public Mono<ServerResponse> getItemsByCategory(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(inventoryService.getItems(serverRequest.pathVariable("category")), Item.class);
    }
}
