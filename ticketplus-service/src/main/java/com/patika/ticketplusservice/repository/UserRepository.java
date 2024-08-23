package com.patika.ticketplusservice.repository;

import com.patika.ticketplusservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    Boolean existsByEmail(String email);

}