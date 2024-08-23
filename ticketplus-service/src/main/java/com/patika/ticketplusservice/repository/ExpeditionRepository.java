package com.patika.ticketplusservice.repository;

import com.patika.ticketplusservice.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpeditionRepository extends JpaRepository<Expedition, Integer> {

    List<Expedition> findByFromCityIgnoreCaseAndToCityIgnoreCase(String fromCity, String toCity);


}
