package com.lambarki.yassine.billingservice.mappers;

import com.lambarki.yassine.billingservice.dtos.InvoiceRequestDTO;
import com.lambarki.yassine.billingservice.dtos.InvoiceResponseDTO;
import com.lambarki.yassine.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDtoToInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoiceToInvoiceResponseDTO(Invoice invoice);
}
