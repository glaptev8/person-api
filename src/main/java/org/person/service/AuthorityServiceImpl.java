package org.person.service;

import org.springframework.stereotype.Service;
import org.person.entity.Authority;
import org.person.repository.AuthorityRepository;

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
