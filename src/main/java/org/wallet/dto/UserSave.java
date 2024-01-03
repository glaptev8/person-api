package org.wallet.dto;

import org.wallet.entity.Address;
import org.wallet.entity.Admin;
import org.wallet.entity.Authority;
import org.wallet.entity.Country;
import org.wallet.entity.Individual;
import org.wallet.entity.Merchant;
import org.wallet.entity.Profile;
import org.wallet.entity.User;

import lombok.Data;

@Data
public class UserSave {
  private User user;
  private Profile profile;
  private Address address;
  private Country country;
  private Merchant merchant;
  private Authority authority;
  private Admin admin;
  private Individual individual;
}
