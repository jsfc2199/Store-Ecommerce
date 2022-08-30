package com.jsfc.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getUnitsAvailable(), that.getUnitsAvailable()) && Objects.equals(getMinAmountUnits(), that.getMinAmountUnits()) && Objects.equals(getMaxAmountUnits(), that.getMaxAmountUnits()) && Objects.equals(getProvider(), that.getProvider());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getUnitsAvailable(), getMinAmountUnits(), getMaxAmountUnits(), getProvider());
    }
}
