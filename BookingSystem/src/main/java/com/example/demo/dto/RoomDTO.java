package com.example.demo.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private Long id;
    private String type;
    private Double price;
    private Boolean available;
    private Long hotelId;
}