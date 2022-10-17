package com.jsfc.store.store.usecases.productusecases;

import com.jsfc.store.store.collections.Product;
import com.jsfc.store.store.dto.ProductDto;
import com.jsfc.store.store.mapper.ProductMapper;
import com.jsfc.store.store.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PutProductUseCase {

    private final ProductMapper productMapper;
    private final IProductRepository productRepository;

    public PutProductUseCase(ProductMapper productMapper, IProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public Mono<ProductDto> updateProduct(@Valid ProductDto productDto){
        if(validator(productDto)){
            return productRepository.save(productMapper.fromDTOtoProduct(productDto)).map(product -> productMapper.fromProductToDTO(product));
        }
        return Mono.error(new IllegalArgumentException("""
                Please check the following specs. It can be both or just one of them
                
                    - The role of user inside the product must be 'provider'
                    - The units available must be less or equal than the maximum units, and greater or equal than the minimum units
                """));
    }

    public boolean validator(ProductDto productDto){

        return productDto.getProvider().getRole().equals("provider") &&
                (productDto.getUnitsAvailable() >= productDto.getMinAmountUnits()) &&
                (productDto.getUnitsAvailable() <= productDto.getMaxAmountUnits());

    }
}
