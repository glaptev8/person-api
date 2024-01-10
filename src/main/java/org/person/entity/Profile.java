package org.person.entity;

import org.leantech.person.dto.ProfileType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
@Table("profiles")
public class Profile {
  @Id
  private UUID uid;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private UUID userUid;
  private ProfileType type;
  private boolean verified;
}
