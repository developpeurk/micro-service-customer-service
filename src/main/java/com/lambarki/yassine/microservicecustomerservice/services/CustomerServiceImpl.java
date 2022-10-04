package com.lambarki.yassine.microservicecustomerservice.services;

import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerRequestDTO;
import com.lambarki.yassine.microservicecustomerservice.dtos.CustomerResponseDTO;
import com.lambarki.yassine.microservicecustomerservice.entities.Customer;
import com.lambarki.yassine.microservicecustomerservice.mappers.CustomerMapper;
import com.lambarki.yassine.microservicecustomerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        return null;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        return null;
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        return null;
    }
}
