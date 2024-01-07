package org.person.service;

import org.springframework.stereotype.Service;
import org.person.entity.Admin;
import org.person.repository.AdminRepository;
import org.person.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final AdminRepository adminRepository;
  private final ProfileRepository profileRepository;

  @Override
  public Mono<Admin> save(Admin admin) {
    if (admin == null) {
      return Mono.error(new RuntimeException(""));
    }
    return profileRepository.existsById(admin.getProfileUid())
      .flatMap(profileExists -> {
        if (profileExists) {
          return adminRepository.save(admin);
        }
        return Mono.error(new RuntimeException(""));
      });
  }
}
