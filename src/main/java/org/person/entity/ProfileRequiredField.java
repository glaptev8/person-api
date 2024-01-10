package org.person.entity;

import lombok.Data;

import org.leantech.person.dto.DataType;
import org.leantech.person.dto.ProfileType;
import org.leantech.person.dto.ValidationRules;
import org.leantech.person.dto.ValidationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("profile_required_fields")
public class ProfileRequiredField {

  @Id
  private UUID uid;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String countryAlpha3Code;
  private ValidationType validationType;
  private ValidationRules validationRules;
  private DataType dataType;
  private String key;
  private String language;
  private String representationName;
  private String description;
  private String defaultValue;
  private ProfileType profileType;
  private Long sortingIndex;
  private String placeholder;
}

