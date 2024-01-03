package org.wallet.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.User;

public interface UserRepository extends R2dbcRepository<User, UUID> {
}
