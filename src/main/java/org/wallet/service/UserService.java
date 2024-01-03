package org.wallet.service;

import org.wallet.dto.UserSave;
import org.wallet.dto.UserSaveDto;
import org.wallet.entity.User;

import reactor.core.publisher.Mono;

public interface UserService {
  Mono<User> save(UserSave user);
}
