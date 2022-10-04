package com.lambarki.yassine.billingservice.services;

import com.lambarki.yassine.billingservice.dtos.InvoiceRequestDTO;
import com.lambarki.yassine.billingservice.dtos.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceID);
    List<InvoiceResponseDTO> invoicesByCustomer(String customerID);
    List<InvoiceResponseDTO> allInvoices();

}
