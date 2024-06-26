package com.novatech.aquamarine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //Query personalizada para o endpoint de autenticação 
    User findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
