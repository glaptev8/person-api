package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Country;

import reactor.core.publisher.Mono;

public interface CountryRepository extends R2dbcRepository<Country, Integer> {
  Mono<Country> findByName(String name);
}
