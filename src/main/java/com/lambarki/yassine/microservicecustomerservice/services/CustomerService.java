package com.lambarki.yassine.microservicecustomerservice.services;

import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerRequestDTO;
import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
     CustomerResponseDTO getCustomer(String id);
     List<CustomerResponseDTO> listCustomers();
     CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
     CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
     void deleteCustomer(String id);


}
