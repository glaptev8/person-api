package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Address;

public interface AddressRepository extends R2dbcRepository<Address, Long>  {
}
