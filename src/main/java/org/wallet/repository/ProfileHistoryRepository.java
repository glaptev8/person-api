package org.wallet.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.dto.ProfileType;
import org.wallet.entity.ProfileHistory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileHistoryRepository extends R2dbcRepository<ProfileHistory, Integer>  {
  Mono<ProfileHistory> findByTargetProfileUid(UUID uuid);
}
