package com.novatech.aquamarine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.EventParticipants;

public interface EventParticipantsRepository extends JpaRepository<EventParticipants, Long>{
    
}
