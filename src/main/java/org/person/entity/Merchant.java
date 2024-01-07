package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.person.dto.MerchantStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("merchants")
public class Merchant {
  @Id
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String companyName;
  private String email;
  private String phoneNumber;
  private String registrationNumber;
  private LocalDateTime verifiedAt;
  private LocalDateTime archivedAt;
  private MerchantStatus status;
  private UUID profileUid;
  private boolean filled;
  private String applicantId;
  private Long addressId;
  private String merchantApiKey;
  private String merchantLogoUrl;
}
