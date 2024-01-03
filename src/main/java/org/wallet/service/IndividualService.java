package org.wallet.service;

import org.wallet.entity.Individual;

import reactor.core.publisher.Mono;

public interface IndividualService {
  Mono<Individual> save(Individual individual);
}
