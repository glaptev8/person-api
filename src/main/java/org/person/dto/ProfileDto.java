package org.person.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private UUID userUid;
  private ProfileType type;
  private boolean verified;
}
