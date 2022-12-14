package com.jsfc.store.store.mapper;

import com.jsfc.store.store.collections.Product;
import com.jsfc.store.store.dto.ProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProductMapper {

    public ProductDto fromProductToDTO(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getDescription(),
                product.getPrice(),
                product.getUnitsAvailable(),
                product.getMinAmountUnits(),
                product.getMaxAmountUnits(),
                product.getProvider()
        );
    }

    public Product fromDTOtoProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getBrand(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getUnitsAvailable(),
                productDto.getMinAmountUnits(),
                productDto.getMaxAmountUnits(),
                productDto.getProvider()
        );
    }
}
