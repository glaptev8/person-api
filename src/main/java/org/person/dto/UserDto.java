package org.person.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String username;
  private String email;
  private String password;
  private String phoneNumber;
  private boolean enabled;
  private boolean isAdmin;
  private UUID lastProfileUid;
  private String language;
  private boolean emailVerified;
  private String preferMobile2fa;
  private ProfileType profileType;
  private boolean isPasswordSet;
  private boolean isSocial;
  private boolean is2faEnabled;
  private String secretKey;
}
