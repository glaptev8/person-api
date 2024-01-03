package org.wallet.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.wallet.dto.ProfileType;
import org.wallet.dto.VerificationStatusStatus;

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

