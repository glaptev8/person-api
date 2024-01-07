package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Individual;

public interface IndividualRepository extends R2dbcRepository<Individual, Long>  {
}
