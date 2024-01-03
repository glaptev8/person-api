package org.wallet.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.UserCountry;
import org.wallet.entity.VerificationStatus;

public interface UserCountryRepository extends R2dbcRepository<UserCountry, UUID> {
}
