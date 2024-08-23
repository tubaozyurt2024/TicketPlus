package com.patika.ticketplusservice.repository;

import com.patika.ticketplusservice.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Integer> {
}
