package com.jsfc.store.store.mapper;

import com.jsfc.store.store.collections.ReceiptsForProviders;
import com.jsfc.store.store.dto.ReceiptsForProvidersDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ReceiptMapper {

    public ReceiptsForProvidersDto fromReceiptToDTO(ReceiptsForProviders receiptsForProviders){
        return new ReceiptsForProvidersDto(
                receiptsForProviders.getProviderId(),
                receiptsForProviders.getProductsThatIamGoingToReceive(),
                receiptsForProviders.getDate(),
                receiptsForProviders.getProviderId()
        );
    }

    public ReceiptsForProviders fromDTOtoReceipt(ReceiptsForProvidersDto receiptsForProvidersDto){
        return new ReceiptsForProviders(
                receiptsForProvidersDto.getProviderId(),
                receiptsForProvidersDto.getProductsThatIamGoingToReceive(),
                receiptsForProvidersDto.getDate(),
                receiptsForProvidersDto.getProviderId()
        );
    }
}
