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
public class PutUserUseCase {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public PutUserUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Mono<UserDto> updateUser(@Valid UserDto userDto){
        return userRepository.save(userMapper.fromDTOToUser(userDto)).map(user -> userMapper.fromUserToDTO(user));
    }
}
