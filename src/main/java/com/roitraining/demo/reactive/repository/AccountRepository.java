package com.roitraining.demo.reactive.repository;

import com.roitraining.demo.reactive.domain.Account;
import com.roitraining.demo.reactive.domain.Item;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Repository
public class AccountRepository {

    private final List<Account> accounts = List.of(new Account(), new Account(), new Account(), new Account());
    private Flux<Account> accountPublisher = Flux.empty();

    public Flux<Account> getAccounts() {
        accountPublisher = Flux.fromIterable(accounts);
        return Flux.fromIterable(accounts);
    }

    public Mono<UUID> createAccount(Account acc) {
        accounts.add(acc);
        accountPublisher.publish();
        return Mono.just(acc.getAccountId());
    }

    public Flux<ServerSentEvent<String>> reactOnAccountPublisher() {
        return accountPublisher.doOnNext(System.out::println)
                .filter(Objects::nonNull)
                .map(a -> ServerSentEvent.<String>builder()
                        .id(a.getAccountId().toString())
                        .build());
    }
}
