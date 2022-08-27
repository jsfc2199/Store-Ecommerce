package com.jsfc.store.store.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Document(collection = "receipts")
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptsForProviders {

    @Id
    private String id;
    private List<Product> productsThatIamGoingToReceive;

    @Pattern(regexp = "(\\b(0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](\\d{4})\\b)|(\\b(0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](\\d{4}|\\d{2})\\b)",
            message = "The field doesn't match with the valid date format ")
    private String date;
    private String providerId;

}
