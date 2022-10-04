package com.lambarki.yassine.billingservice.services;

import com.lambarki.yassine.billingservice.dtos.InvoiceRequestDTO;
import com.lambarki.yassine.billingservice.dtos.InvoiceResponseDTO;
import com.lambarki.yassine.billingservice.entities.Customer;
import com.lambarki.yassine.billingservice.entities.Invoice;
import com.lambarki.yassine.billingservice.mappers.InvoiceMapper;
import com.lambarki.yassine.billingservice.openfeign.CustomerRestClient;
import com.lambarki.yassine.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerServiceRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerServiceRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDtoToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        /*
        * Verification de l'intégrité reférentielle Invoice / Customer
        * */
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoiceToInvoiceResponseDTO(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceID) {
        Invoice invoice = invoiceRepository.findById(invoiceID).get();
        Customer customer = customerRestClient.getCustomerByID(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomer(String customerID) {
        List<Invoice> invoices = invoiceRepository.findByCustomerID(customerID);
        invoices.forEach(invoice -> {
            Customer customer = customerRestClient.getCustomerByID(invoice.getCustomerID());
            invoice.setCustomer(customer);
        });
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoiceToInvoiceResponseDTO(invoice)).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        invoices.forEach(invoice -> {
            Customer customer = customerRestClient.getCustomerByID(invoice.getCustomerID());
            invoice.setCustomer(customer);
        });
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoiceToInvoiceResponseDTO(invoice)).collect(Collectors.toList());
    }
}
