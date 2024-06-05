package com.novatech.aquamarine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class EventParticipants {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long participantId;

    @ManyToOne
    private User user;

    @ManyToOne
    private CleanUpEvent cleanUpEvent;
}
