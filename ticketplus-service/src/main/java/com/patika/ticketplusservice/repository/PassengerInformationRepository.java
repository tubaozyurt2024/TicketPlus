package com.patika.ticketplusservice.repository;

import com.patika.ticketplusservice.model.PassengerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerInformationRepository extends JpaRepository<PassengerInformation, Integer> {
}
