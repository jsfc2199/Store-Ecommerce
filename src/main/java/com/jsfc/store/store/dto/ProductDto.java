package com.jsfc.store.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;

    @NotNull(message = "This field can't be null")
    @NotBlank(message = "Please enter the product's name")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "This field doesn't match with the valid format. At least two letters")
    private String name;

    @NotNull(message = "This field can't be null")
    @NotBlank(message = "Please enter the product's brand")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "This field doesn't match with the valid format. At least two letters")
    private String brand;

    @NotNull(message = "This field can't be null")
    @NotBlank(message = "Please enter the product's description")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "This field doesn't match with the valid format. At least two letters")
    private String description;

    @NotNull(message = "This field can't be null")
    @PositiveOrZero(message = "This field must be equal or greater than zero")
    private Double price;

    @Min(value = 0, message = "You can't have less than zero units")
    @NotNull(message = "This field can't be null")
    @PositiveOrZero(message = "This field must be equal or greater than zero")
    private Integer unitsAvailable;

    @Min(value = 0, message = "You can't have less than zero units")
    @NotNull(message = "This field can't be null")
    @PositiveOrZero(message = "This field must be equal or greater than zero")
    private Integer minAmountUnits;

    @NotNull(message = "This field can't be null")
    @Positive(message = "This field must be positive")
    private Integer maxAmountUnits;

    @NotNull(message = "This field can't be null")
    @Valid
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
