package com.jsfc.store.store.repository;

import com.jsfc.store.store.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> getBypassportId(String passportId);
    Mono<User> getByEmail(String email);
}
