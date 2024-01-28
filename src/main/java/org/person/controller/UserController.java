package org.person.controller;

import java.util.UUID;

import org.leantech.person.dto.ProfileDto;
import org.leantech.person.dto.UserDto;
import org.leantech.person.dto.UserSaveDto;
import org.leantech.person.dto.VerificationStatusDto;
import org.person.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;
  private final MapStructMapper mapper;
  private final ProfileService profileService;
  private final VerificationStatusService verificationStatusService;

  @PostMapping("/save")
  public Mono<UserDto> saveUser(@RequestBody UserSaveDto userSaveDto) {
    return userService.save(mapper.userSaveMapperDto(userSaveDto))
      .map(mapper::userMapper);
  }

  @PostMapping("/userInfo")
  public Mono<UserDto> saveUser(@RequestBody String email) {
    log.info("email {}", email);
    return userService.userInfo(email);
  }

  @PostMapping("/verify")
  public Mono<VerificationStatusDto> verifyUser(@RequestBody VerificationStatus verificationStatus) {
    return verificationStatusService
      .save(verificationStatus)
      .map(mapper::verificationStatusMapper);
  }

  @GetMapping("/profile/{profileUid}")
  public Mono<ProfileDto> getProfile(@PathVariable UUID profileUid) {
    return profileService.getProfileByUid(profileUid)
      .map(mapper::profileMapper);
  }
}
