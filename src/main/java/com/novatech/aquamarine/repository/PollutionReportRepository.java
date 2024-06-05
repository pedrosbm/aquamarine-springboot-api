package com.novatech.aquamarine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatech.aquamarine.model.PollutionReport;

public interface PollutionReportRepository extends JpaRepository<PollutionReport, Long>{
    
}
