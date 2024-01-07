package org.person.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private Integer countryId;
  private String address;
  private String zipCode;
  private LocalDateTime archivedAt;
  private String city;
  private String state;
}
