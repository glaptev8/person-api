package org.person.entity;

import org.leantech.person.dto.ProfileType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
@Table("users")
public class User {

  @Id
  private UUID uid;
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
  @Column(value = "prefer_mobile_2fa")
  private String preferMobile2fa;
  private ProfileType profileType;
  private boolean isPasswordSet;
  private boolean isSocial;
  @Column(value = "is_2fa_enabled")
  private boolean is2faEnabled;
  private String secretKey;
}
