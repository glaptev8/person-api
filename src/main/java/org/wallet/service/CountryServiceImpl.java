package org.wallet.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.transaction.support.TransactionOperations;
import org.wallet.entity.Country;
import org.wallet.entity.UserCountry;
import org.wallet.repository.CountryRepository;
import org.wallet.repository.UserCountryRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

  private final CountryRepository countryRepository;
  private final UserCountryRepository userCountryRepository;
  private final TransactionalOperator transactionalOperator;

  @Override
  public Mono<Country> save(Country country, UUID userUid) {
    return transactionalOperator.transactional(
      Mono.defer(() -> countryRepository.save(country)
        .flatMap(savedCountry -> userCountryRepository.save(UserCountry.builder()
                                                              .countryId(savedCountry.getId())
                                                              .userUid(userUid)
                                                              .build())
          .then(Mono.just(savedCountry))))
    );
  }
}
