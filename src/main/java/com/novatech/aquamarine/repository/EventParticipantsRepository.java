package com.novatech.aquamarine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.EventParticipants;
import java.util.List;


public interface EventParticipantsRepository extends JpaRepository<EventParticipants, Long>{
    List<EventParticipants> findByCleanUpEventEventId(Long eventId);
}
