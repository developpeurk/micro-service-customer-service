package com.lambarki.yassine.microservicecustomerservice;

import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerRequestDTO;
import com.lambarki.yassine.microservicecustomerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroServiceCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","client1","client1@client1.com"));
            customerService.save(new CustomerRequestDTO("C02","client2","client2,@client2.com"));
        };
    }
}
