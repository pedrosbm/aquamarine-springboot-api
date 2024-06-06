package com.novatech.aquamarine.model;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class Login {

    @Email
    private String userEmail;

    private String userPassword;
}
