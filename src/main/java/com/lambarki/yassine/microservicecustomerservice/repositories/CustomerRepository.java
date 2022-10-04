package com.lambarki.yassine.microservicecustomerservice.repositories;

import com.lambarki.yassine.microservicecustomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>{
}
