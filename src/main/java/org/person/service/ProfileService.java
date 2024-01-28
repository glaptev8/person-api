package org.person.service;

import java.util.UUID;

import org.person.entity.Profile;

import reactor.core.publisher.Mono;

public interface ProfileService {
  Mono<Profile> save(Profile profile);

  Mono<Profile> getProfileByUid(UUID profileUid);

  Mono<Profile> getProfileByUserUid(UUID userUid);
}
