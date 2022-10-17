package com.jsfc.store.store.repository;

import com.jsfc.store.store.collections.Product;
import com.jsfc.store.store.dto.ProductDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
    Mono<ProductDto> getByName(String name);

    Mono<ProductDto> getByBrand(String brand);

    Mono<ProductDto> getById(String brand);
}
