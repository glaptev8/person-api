package org.person.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("profile_wallet_types")
public class ProfileWalletType {
  @Id
  private Long id;
  private UUID userUid;
  private UUID profileUid;
  private Integer walletTypeId;
}
