package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.VerificationStatus;

public interface VerificationStatusRepository extends R2dbcRepository<VerificationStatus, Long>  {
}
