package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Country;
import org.wallet.entity.VerificationStatus;

import reactor.core.publisher.Mono;

public interface CountryRepository extends R2dbcRepository<Country, Integer> {
  Mono<Country> findByName(String name);
}
