package com.jsfc.store.store.dto;

import com.jsfc.store.store.collections.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillForClientsDto {

    private String id;

    @Pattern(regexp = "(\\b(0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](\\d{4})\\b)|(\\b(0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](\\d{4}|\\d{2})\\b)",
            message = "The field doesn't match with the valid date format ")
    @NotBlank(message = "Please enter the day")
    private String date;

    @NotBlank(message = "Please enter the client's name")
    private String clientName;

    @NotBlank(message = "Please enter the seller's name")
    private String sellerName;

    private List<Product> productsBought;

    @NotBlank(message = "Please enter the total payment")
    private Double totalPaid;
}
