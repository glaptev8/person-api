package org.person.service;

import org.springframework.stereotype.Service;
import org.person.entity.Merchant;
import org.person.repository.AddressRepository;
import org.person.repository.MerchantRepository;
import org.person.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

  private final MerchantRepository merchantRepository;
  private final AddressRepository addressRepository;
  private final ProfileRepository profileRepository;

  @Override
  public Mono<Merchant> save(Merchant merchant) {
    if (merchant == null) {
      return Mono.error(new RuntimeException(""));
    }
    return addressRepository.existsById(merchant.getAddressId())
      .flatMap(addressExists -> {
        if (addressExists) {
          return profileRepository.existsById(merchant.getProfileUid())
            .flatMap(profileExists -> {
              if (profileExists) {
                return merchantRepository.save(merchant);
              }
              return Mono.error(new RuntimeException(""));
            });
        }
        return Mono.error(new RuntimeException(""));
      });
  }
}
