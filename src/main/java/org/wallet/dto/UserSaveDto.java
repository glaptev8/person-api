package org.wallet.dto;

import lombok.Data;

@Data
public class UserSaveDto {
  private UserDto user;
  private ProfileDto profile;
  private AddressDto address;
  private CountryDto country;
  private MerchantDto merchant;
  private AuthorityDto authority;
  private AdminDto admin;
  private IndividualDto individual;
}
