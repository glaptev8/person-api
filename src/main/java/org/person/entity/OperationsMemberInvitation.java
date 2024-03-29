package org.person.entity;

import lombok.Data;

import org.leantech.person.dto.OperationsMemberInvitationRole;
import org.leantech.person.dto.OperationsMemberInvitationStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("operations_members_invitations")
public class OperationsMemberInvitation {
  @Id
  private UUID uid;
  private LocalDateTime createdAt;
  private LocalDateTime expiresIn;
  private String firstName;
  private String lastName;
  private String email;
  private OperationsMemberInvitationStatus status;
  private OperationsMemberInvitationRole role;
}

