package org.wallet.service;

import org.springframework.stereotype.Service;
import org.wallet.entity.Authority;
import org.wallet.repository.AuthorityRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

  private final AuthorityRepository authorityRepository;

  @Override
  public Mono<Authority> save(Authority authority) {
    if (authority == null) {
      return Mono.error(new RuntimeException(""));
    }
    return authorityRepository.save(authority);
  }
}
