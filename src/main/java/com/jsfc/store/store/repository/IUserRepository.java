package com.jsfc.store.store.repository;

import com.jsfc.store.store.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<User, String> {
}
