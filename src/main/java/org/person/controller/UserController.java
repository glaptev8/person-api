package org.person.controller;

import org.leantech.person.dto.UserDto;
import org.leantech.person.dto.UserSaveDto;
import org.leantech.person.dto.VerificationStatusDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.person.entity.User;
import org.person.entity.VerificationStatus;
import org.person.mapper.MapStructMapper;
import org.person.service.UserService;
import org.person.service.VerificationStatusService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;
  private final MapStructMapper mapper;
  private final VerificationStatusService verificationStatusService;

  @PostMapping("/save")
  public Mono<UserDto> saveUser(@RequestBody UserSaveDto userSaveDto) {
    return userService.save(mapper.userSaveMapperDto(userSaveDto))
      .map(mapper::userMapper);
  }

  @PostMapping("/userInfo")
  public Mono<UserDto> saveUser(@RequestBody String email) {
    return userService.userInfo(email)
      .map(mapper::userMapper);
  }

  @PostMapping("/verify")
  public Mono<VerificationStatusDto> verifyUser(@RequestBody VerificationStatus verificationStatus) {
    return verificationStatusService
      .save(verificationStatus)
      .map(mapper::verificationStatusMapper);
  }
}
