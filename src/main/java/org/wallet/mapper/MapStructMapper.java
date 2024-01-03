package org.wallet.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.wallet.dto.AddressDto;
import org.wallet.dto.AdminDto;
import org.wallet.dto.AuthorityDto;
import org.wallet.dto.CountryDto;
import org.wallet.dto.IndividualDto;
import org.wallet.dto.MerchantDto;
import org.wallet.dto.ProfileDto;
import org.wallet.dto.UserDto;
import org.wallet.dto.UserSave;
import org.wallet.dto.UserSaveDto;
import org.wallet.entity.Address;
import org.wallet.entity.Admin;
import org.wallet.entity.Authority;
import org.wallet.entity.Country;
import org.wallet.entity.Individual;
import org.wallet.entity.Merchant;
import org.wallet.entity.Profile;
import org.wallet.entity.User;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
   User userMapperDto(UserDto userDto); 
   Profile profileMapperDto(ProfileDto profileDto);
   Address addressMapperDto(AddressDto addressDto);
   Country countryMapperDto(CountryDto countryDto);
   Merchant merchantMapperDto(MerchantDto merchantDto);
   Individual individualMapperDto(IndividualDto individualDto);
   Authority authorityMapperDto(AuthorityDto authorityDto);
   Admin adminMapperDto(AdminDto adminDto);
   UserDto userMapper(User user);

  @Mapping(source = "user", target = "user")
  @Mapping(source = "profile", target = "profile")
  @Mapping(source = "address", target = "address")
  @Mapping(source = "country", target = "country")
  @Mapping(source = "merchant", target = "merchant")
  @Mapping(source = "authority", target = "authority")
  @Mapping(source = "admin", target = "admin")
  @Mapping(source = "individual", target = "individual")
  UserSave userSaveMapperDto(UserSaveDto userSaveDto);
}
