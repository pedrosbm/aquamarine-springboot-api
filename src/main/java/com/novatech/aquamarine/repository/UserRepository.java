package com.novatech.aquamarine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
