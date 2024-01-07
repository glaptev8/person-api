package org.person.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.person.dto.UserSaveDto;
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
  public Mono<User> saveUser(@RequestBody UserSaveDto userSaveDto) {
    return userService.save(mapper.userSaveMapperDto(userSaveDto));
  }

  @PostMapping("/verify")
  public Mono<VerificationStatus> verifyUser(@RequestBody VerificationStatus verificationStatus) {
    return verificationStatusService.save(verificationStatus);
  }
}
