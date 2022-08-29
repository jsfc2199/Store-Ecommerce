package com.jsfc.store.store.collections;

import com.jsfc.store.store.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;


    private String nombre;

    //@Indexed(unique = true)
    private String contactCellPhoneNumber;

    //@Indexed(unique = true)
    private String passportId;

    //@Indexed(unique = true)
    private String email;

    private String password;
    private String role;
    private List<ProductDto> products;
}

