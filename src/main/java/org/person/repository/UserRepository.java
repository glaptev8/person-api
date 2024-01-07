package org.person.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.User;

public interface UserRepository extends R2dbcRepository<User, UUID> {
}
