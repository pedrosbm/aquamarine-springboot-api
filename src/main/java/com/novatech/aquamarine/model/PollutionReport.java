package com.novatech.aquamarine.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Builder
public class PollutionReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long reportId;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private LocalDate reportDate;

    @Lob
    private byte[] reportPicture;

    private String reportDescription;

    private String reportStatus;

    private String reportSeverity;

    private Double latitude;

    private Double longitude;

    @ManyToOne
    private User user;

    @OneToOne
    private CleanUpEvent cleanUpEvent;
}
