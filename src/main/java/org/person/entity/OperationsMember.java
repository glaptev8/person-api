package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.person.dto.OperationsMemberRole;
import org.person.dto.OperationsMemberStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("operations_members")
public class OperationsMember {
  @Id
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String firstName;
  private String lastName;
  private String email;
  private UUID profileUid;
  private OperationsMemberStatus status;
  private OperationsMemberRole role;
  private LocalDateTime archivedAt;
}

