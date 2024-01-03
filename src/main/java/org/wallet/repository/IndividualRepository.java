package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Country;
import org.wallet.entity.Individual;

public interface IndividualRepository extends R2dbcRepository<Individual, Long>  {
}
