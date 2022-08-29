package com.jsfc.store.store.usecases.userusecases;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.mapper.UserMapper;
import com.jsfc.store.store.repository.IUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetByPassportIdUseCase {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public GetByPassportIdUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //get an user by passport id
    public Mono<UserDto> getBypassportId (String passportId){
        return userRepository.getBypassportId(passportId).map(user -> userMapper.fromUserToDTO(user));
    }
}
