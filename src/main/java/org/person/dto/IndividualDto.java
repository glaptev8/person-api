package org.person.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String firstName;
  private String lastName;
  private LocalDateTime dateOfBirth;
  private String passportNumber;
  private String personalIdentityNumber;
  private GenderType gender;
  private String status;
  private LocalDateTime verifiedAt;
  private LocalDateTime archivedAt;
  private String email;
  private String phone;
  private boolean filled;
  private String applicantId;
}
