package com.jsfc.store.store.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Document(collection = "bills")
@AllArgsConstructor
@NoArgsConstructor
public class BillForClients {
    @Id
    private String id;

    private String date;
    private String clientName;
    private String sellerName;
    private List<Product> productsBought;
    private Double totalPaid;
}
