package com.lambarki.yassine.microservicecustomerservice.web;

import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerRequestDTO;
import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerResponseDTO;
import com.lambarki.yassine.microservicecustomerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @PutMapping(path = "/customers/{id}")
    public CustomerResponseDTO update(@RequestBody CustomerRequestDTO customerRequestDTO, @PathVariable String id){
        customerRequestDTO.setId(id);
        return customerService.save(customerRequestDTO);
    }

    @DeleteMapping(path = "/customers/{id}")
    public void delete(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
}
