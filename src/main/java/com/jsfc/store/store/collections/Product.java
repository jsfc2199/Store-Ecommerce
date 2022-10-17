package com.jsfc.store.store.collections;

import com.jsfc.store.store.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String brand;
    private String description;
    private Double price;
    private Integer unitsAvailable;
    private Integer minAmountUnits;
    private Integer maxAmountUnits;
    private UserDto provider; //only if its role is provider

}
