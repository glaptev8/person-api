package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("countries")
public class Country {
  @Id
  private Integer id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String name;
  private String alpha3;
  private boolean isActive;
  private String alpha2;
}
