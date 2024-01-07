package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.person.dto.ProfileType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("users_profile_filters")
public class UserProfileFilter {
  @Id
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private UUID profileUid;
  private UUID userUid;
  private ProfileType profileType;
  private boolean verified;
}
