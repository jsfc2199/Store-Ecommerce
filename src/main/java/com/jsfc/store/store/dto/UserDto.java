package com.jsfc.store.store.dto;


import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.List;
import java.util.Objects;

@Data
public class UserDto {

    private String id;

    @NotNull(message = "The name field can't be null")
    @NotBlank(message = "Please enter a name")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "This field doesn't match with the valid format. At least two letters")
    private String name;

    @NotNull(message = "The cellphone field can't be null")
    @NotBlank(message = "Please enter a cellphone number")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4,12}$",
            message = "The field doesn't match with the valid format. Can have the country code with maximum 3 characters, " +
                    "or just the phone number with maximum 18 numbers and minimum 10")
    private String contactCellPhoneNumber;

    @NotNull(message = "The passport id field can't be null")
    @NotBlank(message = "Please enter a passportId")
    @Pattern(regexp = "^(?!^0+$)[a-zA-Z0-9]{8,20}$", message = "The field doesn't match with the valid format. Can have letters and numbers, maximum 20 characters and minimum 8")
    private String passportId;

    @NotNull(message = "The email field can't be null")
    @NotBlank(message = "Please enter an email")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "This field doesn't match with the valid email format. Can be 'example@example.com'")
    private String email;

    @NotNull(message = "The password field can't be null")
    @NotBlank(message = "Please enter a password")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?/_'’+>!\"$%±&¿³¡²?;µ.:§ª¨·,¶¹<=»«´¯({ñ¥Ñ|£°¬}`~)!¢÷‰@^*ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ€≠≤≥√Ω-]).{8,}$",
            message = "The field doesn't match with the password format. At least 1 uppercase - 1 lowercase - 1 number - 1 special character - and minimum 8 characters")
    private String password;

    @NotNull(message = "The role field can't be null")
    @NotBlank(message = "Please enter a role")
    @Pattern(regexp = "^((admin|provider|client))$", message = "The field doesn't match with the correct roles. Just can be admin, provider client")
    private String role;

    private List<ProductDto> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) && Objects.equals(getName(), userDto.getName()) && Objects.equals(getContactCellPhoneNumber(), userDto.getContactCellPhoneNumber()) && Objects.equals(getPassportId(), userDto.getPassportId()) && Objects.equals(getEmail(), userDto.getEmail()) && Objects.equals(getPassword(), userDto.getPassword()) && Objects.equals(getRole(), userDto.getRole()) && Objects.equals(getProducts(), userDto.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getContactCellPhoneNumber(), getPassportId(), getEmail(), getPassword(), getRole(), getProducts());
    }
}
