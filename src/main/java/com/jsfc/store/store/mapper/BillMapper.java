package com.jsfc.store.store.mapper;

import com.jsfc.store.store.collections.BillForClients;
import com.jsfc.store.store.dto.BillForClientsDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class BillMapper {

    public BillForClientsDto fromBillToDTO(BillForClients bill){
        return new BillForClientsDto(
                bill.getId(),
                bill.getDate(),
                bill.getClientName(),
                bill.getSellerName(),
                bill.getProductsBought(),
                bill.getTotalPaid()
        );
    }

    public BillForClients fromDTOToBill(BillForClientsDto billForClientsDto){
        return new BillForClients(
                billForClientsDto.getId(),
                billForClientsDto.getDate(),
                billForClientsDto.getClientName(),
                billForClientsDto.getSellerName(),
                billForClientsDto.getProductsBought(),
                billForClientsDto.getTotalPaid()
        );
    }
}
