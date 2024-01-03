package org.wallet.service;

import org.wallet.entity.Profile;

import reactor.core.publisher.Mono;

public interface ProfileService {
  Mono<Profile> save(Profile profile);
}
