package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("admins")
public class Admin {
  @Id
  private Integer id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private UUID profileUid;
  private String name;
  private String surname;
  private String status;
  private LocalDateTime archivedAt;
}

