package org.wallet.service;

import org.wallet.entity.VerificationStatus;

import reactor.core.publisher.Mono;

public interface VerificationStatusService {
  Mono<VerificationStatus> save(VerificationStatus verificationStatus);
}
