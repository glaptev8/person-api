package org.wallet.service;

import org.springframework.stereotype.Service;
import org.wallet.entity.VerificationStatus;
import org.wallet.repository.ProfileRepository;
import org.wallet.repository.VerificationStatusRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VerificationStatusServiceImpl implements VerificationStatusService {

  private final ProfileRepository profileRepository;
  private final VerificationStatusRepository verificationStatusRepository;

  @Override
  public Mono<VerificationStatus> save(VerificationStatus verificationStatus) {
    return profileRepository.findById(verificationStatus.getTargetProfileUid())
      .flatMap(profile -> verificationStatusRepository.save(verificationStatus))
      .switchIfEmpty(Mono.error(new RuntimeException("")));
  }
}
