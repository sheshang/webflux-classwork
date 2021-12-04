package com.roitraining.demo.reactive.controller;

import com.roitraining.demo.reactive.domain.Account;
import com.roitraining.demo.reactive.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAllAccounts() {

        Mockito.when(accountService.getAccounts()).thenReturn(Flux.just(new Account()));

        webTestClient
                .get().uri("/accounts")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Account.class).value(accounts -> assertAll(
                        () -> assertThat(accounts.size()).isEqualTo(1),
                        () -> assertNotNull(accounts.get(0).getAccountId())
                ));
    }
}
