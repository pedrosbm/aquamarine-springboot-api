package com.novatech.aquamarine.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CleanUpEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long eventId;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalTime eventDate;
}
