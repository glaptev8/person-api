package org.person.entity;

import lombok.Data;

import org.leantech.person.dto.MerchantMemberRole;
import org.leantech.person.dto.MerchantMemberStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("merchant_members")
public class MerchantMember {
  @Id
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private Long merchantId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private MerchantMemberRole merchantMemberRole;
  private MerchantMemberStatus status;
  private String applicantId;
  private String invitationLink;
  private boolean verified;
  private boolean filled;
  private LocalDateTime verifiedAt;
  private LocalDateTime archivedAt;
  private UUID profileUid;
}

