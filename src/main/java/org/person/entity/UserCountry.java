package org.person.entity;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder
@Table("users_countries")
public class UserCountry {
  private UUID userUid;
  private Integer countryId;
}
