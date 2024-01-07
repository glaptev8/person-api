package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Authority;

public interface AuthorityRepository extends R2dbcRepository<Authority, Integer>  {
}
