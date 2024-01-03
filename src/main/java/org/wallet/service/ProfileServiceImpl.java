package org.wallet.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.wallet.dto.ProfileType;
import org.wallet.entity.Profile;
import org.wallet.entity.ProfileHistory;
import org.wallet.repository.ProfileHistoryRepository;
import org.wallet.repository.ProfileRepository;
import org.wallet.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

  private final ProfileRepository profileRepository;
  private final UserRepository userRepository;
  private final ProfileHistoryRepository profileHistoryRepository;

  @Override
  public Mono<Profile> save(Profile profile) {
    return userRepository.findById(profile.getUserUid())
      .flatMap(user -> profileRepository.findByUserUid(user.getUid())
        .flatMap(oldProfile -> profileHistoryRepository.findByTargetProfileUid(user.getUid())
          .flatMap(profileHistory ->
                     profileRepository.save(profile)
                       .flatMap(newProfile -> profileHistoryRepository.save(setProfileHistory(profile, profileHistory, oldProfile.getType()))
                         .then(Mono.defer(() -> Mono.just(newProfile)))))
          .switchIfEmpty(Mono.defer(() -> profileRepository.save(profile)
            .flatMap(savedProfile -> profileHistoryRepository.save(setProfileHistory(profile, ProfileHistory.builder().build(), oldProfile.getType()))
              .then(Mono.defer(() -> Mono.just(profile)))))))
        .switchIfEmpty(Mono.defer(() -> profileRepository.save(profile))))
      .switchIfEmpty(Mono.error(new RuntimeException("")));
  }
  private ProfileHistory setProfileHistory(Profile newProfile, ProfileHistory profileHistory, ProfileType oldProfileType) {
    if (CollectionUtils.isEmpty(profileHistory.getChangedValues())) {
      profileHistory.setChangedValues(new ArrayList<>());
    }
    profileHistory.getChangedValues().add(oldProfileType);
    profileHistory.setProfileType(newProfile.getType());
    profileHistory.setChangedByProfileType(newProfile.getType());
    profileHistory.setTargetProfileUid(newProfile.getUserUid());
    profileHistory.setChangedByUserUid(newProfile.getUserUid());

    return profileHistory;
  }
}
