package com.roitraining.demo.reactive.config;

import com.roitraining.demo.reactive.handler.InventoryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Configuration
public class InventoryRouterConfig {
    private final InventoryHandler inventoryHandler;

    public InventoryRouterConfig(InventoryHandler inventoryHandler) {
        this.inventoryHandler = inventoryHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(InventoryHandler inventoryHandler) {
        return RouterFunctions.route()
                .path("functional/inventory",
                        p -> p.nest(accept(MediaType.ALL), b -> b.GET("stream-items", inventoryHandler::getItems)
                                .GET("stream-items/{category}", inventoryHandler::getItemsByCategory)))
                .build();
    }
}
