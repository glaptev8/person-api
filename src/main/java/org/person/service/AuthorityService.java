package org.person.service;

import org.person.entity.Authority;

import reactor.core.publisher.Mono;

public interface AuthorityService {
  Mono<Authority> save(Authority authority);
}
