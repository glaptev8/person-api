package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Admin;

public interface AdminRepository extends R2dbcRepository<Admin, Integer>  {
}
