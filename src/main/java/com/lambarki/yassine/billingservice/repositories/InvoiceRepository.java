package com.lambarki.yassine.billingservice.repositories;

import com.lambarki.yassine.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findByCustomerID(String id);
}
