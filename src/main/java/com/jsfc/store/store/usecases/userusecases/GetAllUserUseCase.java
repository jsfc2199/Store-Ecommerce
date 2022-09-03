package com.jsfc.store.store.usecases.userusecases;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.mapper.UserMapper;
import com.jsfc.store.store.repository.IUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllUserUseCase {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public GetAllUserUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Flux<UserDto> getAllUser(){
        return userRepository.findAll().map(user-> userMapper.fromUserToDTO(user));
    }
}
