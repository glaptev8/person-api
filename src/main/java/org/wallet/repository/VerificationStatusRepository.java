package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.VerificationStatus;

public interface VerificationStatusRepository extends R2dbcRepository<VerificationStatus, Long>  {
}
