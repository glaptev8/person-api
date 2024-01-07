package org.person.dto;

import org.person.entity.Address;
import org.person.entity.Admin;
import org.person.entity.Authority;
import org.person.entity.Country;
import org.person.entity.Individual;
import org.person.entity.Merchant;
import org.person.entity.Profile;
import org.person.entity.User;

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
