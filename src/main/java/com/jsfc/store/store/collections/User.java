package com.jsfc.store.store.collections;

import com.jsfc.store.store.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String contactCellPhoneNumber;
    private String passportId;
    private String email;
    private String password;
    private String role;
    private List<ProductDto> products;
}

