package org.person.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.UserCountry;

public interface UserCountryRepository extends R2dbcRepository<UserCountry, UUID> {
}
