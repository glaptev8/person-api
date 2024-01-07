package org.person.service;

import org.person.entity.Address;

import reactor.core.publisher.Mono;

public interface AddressService {
  Mono<Address> save(Address address);
}
