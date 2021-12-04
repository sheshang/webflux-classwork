package com.roitraining.demo.reactive.controller;

import com.roitraining.demo.reactive.domain.Account;
import com.roitraining.demo.reactive.domain.Order;
import com.roitraining.demo.reactive.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Account APIs")
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accSvc) {
        this.accountService = accSvc;
    }

    // returns response entity of mono
    @GetMapping()
    ResponseEntity getAccounts() {
        return ResponseEntity.ok(this.accountService.getAccounts());
    }

    @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ServerSentEvent<String>> streamAccounts() {
        return this.accountService.streamAccounts();
    }

    // returns mono of response entity
    @PostMapping()
    Mono<ResponseEntity> createNewAccount(@RequestBody Account acc) {
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED)
                .body(this.accountService.createAccount(acc)));
    }

    @GetMapping("/{account-id}")
    Mono<Account> getAccount(@PathVariable("account-id") long accountId) {
        return null;
    }

    @GetMapping("/{account-id}/orders")
    Flux<Order> getAccountOrders(@PathVariable("account-id") long accountId) {
        return null;
    }


}
