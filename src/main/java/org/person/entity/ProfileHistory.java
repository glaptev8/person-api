package org.person.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.person.dto.ProfileType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Table("profile_history")
public class ProfileHistory {
  @Id
  private Integer id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private ProfileType profileType;
  private UUID targetProfileUid;
  private ProfileType changedByProfileType;
  private String reason;
  private String comment;
  private UUID changedByUserUid;
  private List<ProfileType> changedValues;
}

