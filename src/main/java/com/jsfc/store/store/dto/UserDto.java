package com.jsfc.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;

    @NotBlank(message = "Please enter a name")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "The field doesn't match with the valid format")
    private String name;

    @NotBlank(message = "Please enter a cellphone number")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "The field doesn't match with the valid format")
    private String contactCellPhoneNumber;

    @NotBlank(message = "Please enter a passportId")
    @Pattern(regexp = "^(?!^0+$)[a-zA-Z0-9]{8,20}$", message = "The field doesn't match with the valid format")
    private String passportId;

    @NotBlank(message = "Please enter an email")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "The field doesn't match with the email format")
    private String email;

    @NotBlank(message = "Please enter a password")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?/_'’+>!\"$%±&¿³¡²?;µ.:§ª¨·,¶¹<=»«´¯({ñ¥Ñ|£°¬}`~)!¢÷‰@^*ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ€≠≤≥√Ω-]).{8,}$",
            message = "The field doesn't match with the password format")
    private String password;

    @NotBlank(message = "Please enter a role")
    @Pattern(regexp = "^((admin|provider|client))$", message = "The field doesn't match with the correct roles")
    private String role;

    @NotBlank(message = "Please enter a list of products")
    private List<ProductDto> products;
}
