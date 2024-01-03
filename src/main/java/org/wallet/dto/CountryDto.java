package org.wallet.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String name;
  private String alpha3;
  private boolean isActive;
  private String alpha2;
}
