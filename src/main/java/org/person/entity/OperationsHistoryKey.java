package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("operations_history_keys")
public class OperationsHistoryKey {
  @Id
  private Integer id;
  private String profileType;
  private String screen;
  private String key;
  private String description;
  private String language;
}
