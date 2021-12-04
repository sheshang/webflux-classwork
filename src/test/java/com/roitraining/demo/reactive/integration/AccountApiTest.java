package com.roitraining.demo.reactive.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountApiTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetAllAccounts() {
        webTestClient
                .get().uri("/accounts")
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).value(accounts -> {
                    assertAll(
                            () -> assertThat(accounts.size()).isEqualTo(4)
                    );
                });

    }
}
