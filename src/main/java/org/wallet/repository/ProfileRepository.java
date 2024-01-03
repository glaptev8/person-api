package org.wallet.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Profile;

import reactor.core.publisher.Mono;

public interface ProfileRepository extends R2dbcRepository<Profile, UUID> {
  Mono<Profile> findByUserUid(UUID uuid);
}
