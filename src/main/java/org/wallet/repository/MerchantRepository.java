package org.wallet.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.wallet.entity.Merchant;

public interface MerchantRepository extends R2dbcRepository<Merchant, Long>  {
}
