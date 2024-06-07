package com.novatech.aquamarine.model;

import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class CleanUpEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long eventId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalTime eventDate;
    
    @OneToOne
    private PollutionReport pollutionReport;

    @OneToMany
    private List<EventParticipants> eventParticipants;
}
