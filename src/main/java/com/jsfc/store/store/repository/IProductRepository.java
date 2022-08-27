package com.jsfc.store.store.repository;

import com.jsfc.store.store.collections.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
