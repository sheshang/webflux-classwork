package com.roitraining.demo.reactive.repository;

import com.roitraining.demo.reactive.domain.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface AccountReactiveRepository extends ReactiveCrudRepository<Account, UUID> {
}
