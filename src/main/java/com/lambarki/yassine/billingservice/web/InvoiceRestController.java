package com.lambarki.yassine.billingservice.web;

import com.lambarki.yassine.billingservice.dtos.InvoiceRequestDTO;
import com.lambarki.yassine.billingservice.dtos.InvoiceResponseDTO;
import com.lambarki.yassine.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {

    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceID){
        return invoiceService.getInvoice(invoiceID);
    }

    @GetMapping(path = "/invoicesByCustomer/{customerID}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable(name = "customerID") String customerId){
        return invoiceService.invoicesByCustomer(customerId);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.allInvoices();
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }

}
