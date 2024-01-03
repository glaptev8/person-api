package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Authority;

public interface AuthorityRepository extends R2dbcRepository<Authority, Integer>  {
}
