package com.novatech.aquamarine.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @CPF
    private Long userCpf;

    private String userName;

    @Email
    private String userEmail;

    private Long userPhone;

    private String userAdress;

    private String userPassword;

    private String userType;
}
