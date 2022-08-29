package com.jsfc.store.store.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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

    private String date;

    @Indexed(unique = true)
    private String providerId;

}
