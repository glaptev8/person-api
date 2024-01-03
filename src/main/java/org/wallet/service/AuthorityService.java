package org.wallet.service;

import org.wallet.entity.Authority;

import reactor.core.publisher.Mono;

public interface AuthorityService {
  Mono<Authority> save(Authority authority);
}
