package org.person.service;

import org.person.entity.VerificationStatus;

import reactor.core.publisher.Mono;

public interface VerificationStatusService {
  Mono<VerificationStatus> save(VerificationStatus verificationStatus);
}
