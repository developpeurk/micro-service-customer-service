package com.lambarki.yassine.billingservice;

import com.lambarki.yassine.billingservice.dtos.InvoiceRequestDTO;
import com.lambarki.yassine.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(12000),"C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(360000),"C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(480000),"C02"));
        };
    }

}
