package org.example.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class CreatePurchaseDto {

    private LocalDateTime start_time;

    private LocalDateTime end_time;

    private String arrival_point;

    private String departure_point;

    private double  price;
}
