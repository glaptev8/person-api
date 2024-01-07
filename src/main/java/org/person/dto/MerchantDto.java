package org.person.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String companyName;
  private String email;
  private String phoneNumber;
  private String registrationNumber;
  private LocalDateTime verifiedAt;
  private LocalDateTime archivedAt;
  private MerchantStatus status;
  private boolean filled;
  private String applicantId;
  private String merchantApiKey;
  private String merchantLogoUrl;
}
