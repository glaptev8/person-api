package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Admin;

public interface AdminRepository extends R2dbcRepository<Admin, Integer>  {
}
