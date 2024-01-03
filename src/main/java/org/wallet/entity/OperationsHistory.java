package org.wallet.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("operations_history")
public class OperationsHistory {
  @Id
  private Long id;
  private LocalDateTime createdAt;
  private String key;
  private String reason;
  private UUID changedByProfileUid;
  private String target;
  private String changedValues;
}

