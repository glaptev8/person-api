package org.wallet.service;

import org.wallet.entity.Merchant;

import reactor.core.publisher.Mono;

public interface MerchantService {
  Mono<Merchant> save(Merchant merchant);
}
