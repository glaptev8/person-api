package org.person.service;

import org.person.entity.Merchant;

import reactor.core.publisher.Mono;

public interface MerchantService {
  Mono<Merchant> save(Merchant merchant);
}
