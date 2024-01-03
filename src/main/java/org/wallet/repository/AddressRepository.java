package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Address;
import org.wallet.entity.VerificationStatus;

public interface AddressRepository extends R2dbcRepository<Address, Long>  {
}
