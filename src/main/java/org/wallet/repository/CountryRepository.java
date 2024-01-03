package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Country;
import org.wallet.entity.VerificationStatus;

public interface CountryRepository extends R2dbcRepository<Country, Integer> {
}
