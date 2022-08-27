package com.jsfc.store.store.mapper;

import com.jsfc.store.store.collections.User;
import com.jsfc.store.store.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class UserMapper {

    public UserDto fromUserToDTO(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getContactCellPhoneNumber(),
                user.getPassportId(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getProducts()
        );
    }

    public User fromDTOToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getContactCellPhoneNumber(),
                userDto.getPassportId(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRole(),
                userDto.getProducts()
        );
    }

}
