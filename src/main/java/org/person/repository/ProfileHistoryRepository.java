package org.person.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.ProfileHistory;

import reactor.core.publisher.Mono;

public interface ProfileHistoryRepository extends R2dbcRepository<ProfileHistory, Integer>  {
  Mono<ProfileHistory> findByTargetProfileUid(UUID uuid);
}
