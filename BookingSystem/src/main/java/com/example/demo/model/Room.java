package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double price;
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}