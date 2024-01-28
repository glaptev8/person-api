package org.person.service;

import org.leantech.person.dto.UserDto;
import org.person.dto.UserSave;
import org.person.entity.User;

import reactor.core.publisher.Mono;

public interface UserService {
  Mono<User> save(UserSave user);

  Mono<UserDto> userInfo(String email);
}
