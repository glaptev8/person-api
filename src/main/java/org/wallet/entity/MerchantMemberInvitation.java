package org.wallet.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.wallet.dto.MerchantMemberInvitationRole;
import org.wallet.dto.MerchantMemberInvitationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("merchant_members_invitations")
public class MerchantMemberInvitation {
  @Id
  private UUID uid;
  private LocalDateTime createdAt;
  private LocalDateTime expiresIn;
  private Long merchantId;
  private String firstName;
  private String lastName;
  private String email;
  private MerchantMemberInvitationRole role;
  private MerchantMemberInvitationStatus status;
}

