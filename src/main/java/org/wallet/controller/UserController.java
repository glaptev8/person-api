package org.wallet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wallet.dto.UserSaveDto;
import org.wallet.entity.User;
import org.wallet.mapper.MapStructMapper;
import org.wallet.service.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;
  private final MapStructMapper mapper;

  @PostMapping("/save")
  public Mono<User> saveUser(@RequestBody UserSaveDto userSaveDto) {
    return userService.save(mapper.userSaveMapperDto(userSaveDto));
  }
}
