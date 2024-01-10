package org.person.entity;

import lombok.Data;

import org.leantech.person.dto.ProfileType;
import org.leantech.person.dto.VerificationStatusStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("verification_statuses")
public class VerificationStatus {
  @Id
  private Integer id;
  private LocalDateTime createdAt;
  private ProfileType profileType;
  private UUID targetProfileUid;
  private String applicantId;
  private String details;
  private VerificationStatusStatus verificationStatus;
  private LocalDateTime modifiedAt;
}

