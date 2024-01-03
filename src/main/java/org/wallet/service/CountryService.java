package org.wallet.service;

import java.util.UUID;

import org.wallet.entity.Country;

import reactor.core.publisher.Mono;

public interface CountryService {
  Mono<Country> save(Country country, UUID userUid);

  Mono<Country> getByName(String name);
}
