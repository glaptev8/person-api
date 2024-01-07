package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.person.dto.ProfileType;

import java.time.LocalDateTime;

@Data
@Table("authorities")
public class Authority {
  @Id
  private Integer id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private ProfileType profileType;
  private String authority;
}

