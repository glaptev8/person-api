package org.wallet.service;

import org.wallet.entity.Address;

import reactor.core.publisher.Mono;

public interface AddressService {
  Mono<Address> save(Address address);
}
