package org.person.service;

import org.person.entity.Profile;

import reactor.core.publisher.Mono;

public interface ProfileService {
  Mono<Profile> save(Profile profile);
}
