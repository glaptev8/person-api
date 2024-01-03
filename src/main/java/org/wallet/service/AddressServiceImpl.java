package org.wallet.service;

import org.springframework.stereotype.Service;
import org.wallet.entity.Address;
import org.wallet.repository.AddressRepository;
import org.wallet.repository.CountryRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;
  private final CountryRepository countryRepository;
  @Override
  public Mono<Address> save(Address address) {
    return countryRepository.existsById(address.getCountryId())
      .flatMap(exists -> {
        if (exists) {
          return addressRepository.save(address);
        }
        return Mono.error(new RuntimeException(""));
      });
  }
}
