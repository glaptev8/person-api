package org.person.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Profile;

import reactor.core.publisher.Mono;

public interface ProfileRepository extends R2dbcRepository<Profile, UUID> {
  Mono<Profile> findByUserUid(UUID uuid);
}
