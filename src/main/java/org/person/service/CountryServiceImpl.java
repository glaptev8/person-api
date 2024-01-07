package org.person.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.person.entity.Country;
import org.person.entity.UserCountry;
import org.person.repository.CountryRepository;
import org.person.repository.UserCountryRepository;

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

  @Override
  public Mono<Country> getByName(String name) {
    return countryRepository.findByName(name);
  }
}
