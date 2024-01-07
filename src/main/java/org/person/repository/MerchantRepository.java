package org.person.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.person.entity.Merchant;

public interface MerchantRepository extends R2dbcRepository<Merchant, Long>  {
}
