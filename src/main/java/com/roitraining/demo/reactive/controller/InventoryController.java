package com.roitraining.demo.reactive.controller;

import com.roitraining.demo.reactive.service.AccountService;
import com.roitraining.demo.reactive.service.InventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Inventory APIs")
@RequestMapping("inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService invSvc) {
        this.inventoryService = invSvc;
    }

    @GetMapping("stream-items")
    ResponseEntity getItems() {
        return ResponseEntity.ok(this.inventoryService.getItems());
    }
}
