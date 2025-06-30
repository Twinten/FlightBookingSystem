package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class HotelDTO {
    private Long id;
    private String name;
    private String city;
    private String address;
    private List<RoomDTO> rooms;
}