package com.jsfc.store.store.usecases.userusecases;

import com.jsfc.store.store.dto.UserDto;
import com.jsfc.store.store.mapper.UserMapper;
import com.jsfc.store.store.repository.IUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetByEmailUseCase {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public GetByEmailUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Mono<UserDto> getByEmail (String email){
        return userRepository.getByEmail(email).map(user -> userMapper.fromUserToDTO(user));
    }
}
