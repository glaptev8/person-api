package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("addresses")
public class Address {
  @Id
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private Integer countryId;
  private String address;
  private String zipCode;
  private LocalDateTime archivedAt;
  private String city;
  private String state;
}
