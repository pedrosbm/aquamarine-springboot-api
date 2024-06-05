package com.novatech.aquamarine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.CleanUpEvent;

public interface CleanUpEventRepository extends JpaRepository<CleanUpEvent, Long>{
    
}
