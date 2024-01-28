package org.person.service;

import java.time.LocalDateTime;

import org.leantech.notification.NotificationDto;
import org.leantech.notification.ObjectTypeEnum;
import org.leantech.notification.TriggerCodeEnum;
import org.leantech.person.dto.UserDto;
import org.leantech.webclient.client.notification.RegisterNotificationProducer;
import org.person.mapper.MapStructMapper;
import org.person.repository.AddressRepository;
import org.person.repository.CountryRepository;
import org.person.repository.IndividualRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.person.dto.UserSave;
import org.person.entity.User;
import org.person.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final TransactionalOperator transactionalOperator;
  private final ProfileService profileService;
  private final AddressService addressService;
  private final CountryService countryService;
  private final AdminService adminService;
  private final MapStructMapper mapper;
  private final AddressRepository addressRepository;
  private final CountryRepository countryRepository;
  private final IndividualRepository individualRepository;
  private final IndividualService individualService;
  private final AuthorityService authorityService;
  private final MerchantService merchantService;
  private final RegisterNotificationProducer registerNotificationProducer;
  private final MessageSourceService messageSourceService;

  @Override
  public Mono<User> save(UserSave userSave) {
    log.info("usersave {}", userSave);
    return saveUser(userSave).map(user -> {
      registerNotificationProducer.sendEvent(NotificationDto.builder().objectId(user.getEmail()).objectType(ObjectTypeEnum.EMAIL).subject(messageSourceService.getMessage("notification.register.subject")).message(messageSourceService.getMessage("notification.register.message")).triggerCode(TriggerCodeEnum.INDIVIDUAL_REGISTERED_101).userUid(user.getUid().toString()).expirationDate(LocalDateTime.now().plusMonths(2L)).build());
      return user;
    });
  }

  private Mono<User> saveUser(UserSave userSave) {
    return transactionalOperator.transactional(Mono.defer(() -> userRepository.existsByEmail(userSave.getUser().getEmail()).flatMap(userExists -> {
      if (userExists) {
        return Mono.error(new RuntimeException("user exists"));
      }
      return userRepository.save(userSave.getUser()).flatMap(user -> {
        userSave.getProfile().setUserUid(user.getUid());
        return profileService.save(userSave.getProfile()).flatMap(profile -> countryService.getByName(userSave.getCountry().getName()).switchIfEmpty(countryService.save(userSave.getCountry(), user.getUid())).flatMap(country -> {
                                                                    log.info("user {}", user);
                                                                    userSave.getAddress().setCountryId(country.getId());
                                                                    return addressService.save(userSave.getAddress()).flatMap(address -> switch (userSave.getProfile().getType()) {
                                                                      case ADMIN -> {
                                                                        userSave.getAdmin().setProfileUid(profile.getUid());
                                                                        yield adminService.save(userSave.getAdmin());
                                                                      }
                                                                      case INDIVIDUAL -> {
                                                                        userSave.getIndividual().setProfileUid(profile.getUid());
                                                                        userSave.getIndividual().setAddressId(address.getId());
                                                                        yield individualService.save(userSave.getIndividual());
                                                                      }
                                                                      case MERCHANT -> {
                                                                        userSave.getMerchant().setProfileUid(profile.getUid());
                                                                        userSave.getMerchant().setAddressId(address.getId());
                                                                        yield merchantService.save(userSave.getMerchant());
                                                                      }
                                                                      case AUTHORITY -> authorityService.save(userSave.getAuthority());
                                                                    });
                                                                  }).then(Mono.just(user))

        );
      });
    })));
  }

  @Override
  public Mono<UserDto> userInfo(String email) {
    return userRepository
      .findByEmail(email)
      .log()
      .flatMap(user -> profileService
        .getProfileByUserUid(user.getUid())
        .log()
        .flatMap(profile -> individualRepository
          .findByProfileUid(profile.getUid())
          .log()
          .flatMap(individual -> addressRepository
            .findById(individual.getAddressId())
            .log()
            .flatMap(address -> countryRepository
              .findById(address.getCountryId())
              .log()
              .map(country -> {
                var userDto = mapper.userMapper(user);
                userDto.setCountry(country.getAlpha3());
                return userDto;
              })
            )
          )
        )
      );
  }
}