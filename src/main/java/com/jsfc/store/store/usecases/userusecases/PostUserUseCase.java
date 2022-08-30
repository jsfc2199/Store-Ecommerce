package com.jsfc.store.store.usecases.userusecases;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.mapper.UserMapper;
import com.jsfc.store.store.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PostUserUseCase {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public PostUserUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Save the userDto converting it from dto to user, and then returns the user converting it from user to dto
    public Mono<UserDto> createUser(@Valid UserDto userDto){
        return userRepository.save(userMapper.fromDTOToUser(userDto))
                .map(user -> userMapper.fromUserToDTO(user));
    }
}
