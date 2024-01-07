package org.person.service;

import org.person.entity.Individual;

import reactor.core.publisher.Mono;

public interface IndividualService {
  Mono<Individual> save(Individual individual);
}
