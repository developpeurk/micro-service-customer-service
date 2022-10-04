package com.lambarki.yassine.microservicecustomerservice.services;

import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerRequestDTO;
import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
     CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
     CustomerResponseDTO getCustomer(String id);
     CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
     List<CustomerResponseDTO> listCustomers();


}
