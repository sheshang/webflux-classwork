package com.roitraining.demo.reactive.service;

import com.roitraining.demo.reactive.domain.Account;
import com.roitraining.demo.reactive.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;

    @Test
    void testGetAllAccounts() {
        Mockito.when(accountRepository.getAccounts()).thenReturn(Flux.just(new Account(), new Account()));

        Flux<Account> accounts = accountService.getAccounts();
        StepVerifier.create(accounts.log())
                .expectNextCount(2)
                .verifyComplete();
    }
}
