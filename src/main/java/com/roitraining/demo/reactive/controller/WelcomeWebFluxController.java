package com.roitraining.demo.reactive.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Welcome APIs")
public class WelcomeWebFluxController {

    @GetMapping("/")
    public Mono<String> welcome() {
        return Mono.just("Welcome Sheshang!");
    }
}
