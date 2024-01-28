package org.person.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Individual;

import reactor.core.publisher.Mono;

public interface IndividualRepository extends R2dbcRepository<Individual, Long>  {
  Mono<Individual> findByProfileUid(UUID profileUid);
}
