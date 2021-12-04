package com.roitraining.demo.reactive.service;

import com.roitraining.demo.reactive.domain.Account;
import com.roitraining.demo.reactive.repository.AccountRepository;
import com.roitraining.demo.reactive.repository.InventoryRepository;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accRepo) {
        this.accountRepository = accRepo;
    }

    public Flux<Account> getAccounts() {
        return this.accountRepository.getAccounts();
    }

    public Mono<UUID> createAccount(Account acc) {
        return this.accountRepository.createAccount(acc);
    }

    public Flux<ServerSentEvent<String>> streamAccounts() {
        return this.accountRepository.reactOnAccountPublisher();
    }
}
