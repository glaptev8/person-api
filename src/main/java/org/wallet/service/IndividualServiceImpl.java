package org.wallet.service;

import org.springframework.stereotype.Service;
import org.wallet.entity.Individual;
import org.wallet.repository.AddressRepository;
import org.wallet.repository.IndividualRepository;
import org.wallet.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService {

  private final IndividualRepository individualRepository;
  private final AddressRepository addressRepository;
  private final ProfileRepository profileRepository;

  @Override
  public Mono<Individual> save(Individual individual) {
    if (individual == null) {
      return Mono.error(new RuntimeException(""));
    }
    return addressRepository.existsById(individual.getAddressId())
      .flatMap(addressExists -> {
        if (addressExists) {
          return profileRepository.existsById(individual.getProfileUid())
            .flatMap(profileExists -> {
              if (profileExists) {
                return individualRepository.save(individual);
              }
              return Mono.error(new RuntimeException(""));
            });
        }
        return Mono.error(new RuntimeException(""));
      });
  }
}
