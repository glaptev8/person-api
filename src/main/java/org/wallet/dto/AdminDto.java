package org.wallet.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private UUID profileUid;
  private String name;
  private String surname;
  private String status;
  private LocalDateTime archivedAt;
}
