package com.patika.ticketpluspaymentservice.repository;

import com.patika.ticketpluspaymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PaymentRepository extends JpaRepository<Payment, Integer> {
}
