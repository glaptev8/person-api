package org.person.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private ProfileType profileType;
  private String authority;
}
