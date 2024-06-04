package com.novatech.aquamarine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Builder
public class PollutionReport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long reportId;

    private Date reportDate;

    @Lob
    private byte[] reportPicture;

    private String reportDescription;

    private String reportStatus;

    private String reportSeverity;

    private Double latitude;

    private Double longitude;
}
