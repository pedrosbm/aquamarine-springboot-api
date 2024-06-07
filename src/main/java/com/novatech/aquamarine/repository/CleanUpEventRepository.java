package com.novatech.aquamarine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.CleanUpEvent;
import java.util.List;

public interface CleanUpEventRepository extends JpaRepository<CleanUpEvent, Long> {
    List<CleanUpEvent> findByPollutionReportReportId(Long reportId);
    
    Page<CleanUpEvent> findByEventParticipantsUserUserId(Long userId, Pageable pageable);
}
