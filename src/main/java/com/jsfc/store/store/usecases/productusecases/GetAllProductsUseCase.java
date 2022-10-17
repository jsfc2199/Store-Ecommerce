package com.jsfc.store.store.usecases.productusecases;

import com.jsfc.store.store.dto.ProductDto;
import com.jsfc.store.store.mapper.ProductMapper;
import com.jsfc.store.store.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProductsUseCase {

    private final ProductMapper productMapper;
    private final IProductRepository productRepository;

    public GetAllProductsUseCase(ProductMapper productMapper, IProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public Flux<ProductDto> getAllProducts(){
        return productRepository.findAll().map(product -> productMapper.fromProductToDTO(product));
    }
}
