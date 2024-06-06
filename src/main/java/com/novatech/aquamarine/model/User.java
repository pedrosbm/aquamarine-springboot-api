package com.novatech.aquamarine.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @CPF
    private Long userCpf;

    private String userName;

    @Email
    private String userEmail;

    private Long userPhone;

    private String userAdress;

    @NotBlank
    private String userPassword;

    private String userType;
}
