package org.person.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.person.dto.AddressDto;
import org.person.dto.AdminDto;
import org.person.dto.AuthorityDto;
import org.person.dto.CountryDto;
import org.person.dto.IndividualDto;
import org.person.dto.MerchantDto;
import org.person.dto.ProfileDto;
import org.person.dto.UserDto;
import org.person.dto.UserSave;
import org.person.dto.UserSaveDto;
import org.person.entity.Address;
import org.person.entity.Admin;
import org.person.entity.Authority;
import org.person.entity.Country;
import org.person.entity.Individual;
import org.person.entity.Merchant;
import org.person.entity.Profile;
import org.person.entity.User;

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
