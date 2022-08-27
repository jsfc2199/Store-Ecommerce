package com.jsfc.store.store.dto;

import com.jsfc.store.store.collections.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;

    @NotBlank(message = "Please enter the product's name")
    private String name;

    @NotBlank(message = "Please enter the product's description")
    private String description;

    @NotBlank(message = "Please enter the product's price")
    private Double price;

    @NotBlank(message = "Please enter the product's units available")
    private Integer unitsAvailable;

    @NotBlank(message = "Please enter the product's minimum units")
    private Integer minAmountUnits;

    @NotBlank(message = "Please enter the product's maximum units")
    private Integer maxAmountUnits;

    @NotBlank(message = "Please enter a provider")
    private UserDto provider;
}
