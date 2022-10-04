package com.lambarki.yassine.microservicecustomerservice.mappers;

import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerRequestDTO;
import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerResponseDTO;
import com.lambarki.yassine.microservicecustomerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
