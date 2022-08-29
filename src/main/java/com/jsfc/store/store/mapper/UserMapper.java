package com.jsfc.store.store.mapper;

import com.jsfc.store.store.collections.User;
import com.jsfc.store.store.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class UserMapper {

    public UserDto fromUserToDTO(User user){

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setNombre(user.getNombre());
        userDto.setContactCellPhoneNumber(user.getContactCellPhoneNumber());
        userDto.setPassportId(user.getPassportId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setProducts(user.getProducts());

        return userDto;
    }

    public User fromDTOToUser(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setNombre(userDto.getNombre());
        user.setContactCellPhoneNumber(userDto.getContactCellPhoneNumber());
        user.setPassportId(userDto.getPassportId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setProducts(userDto.getProducts());

        return user;
    }

}
