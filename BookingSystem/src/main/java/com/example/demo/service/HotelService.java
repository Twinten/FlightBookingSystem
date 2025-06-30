package com.example.demo.service;

import com.example.demo.dto.HotelDTO;
import java.util.List;

public interface HotelService {
    List<HotelDTO> findAllHotels();
    HotelDTO findHotelById(Long id);
    HotelDTO createHotel(HotelDTO hotelDTO);
    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);
    void deleteHotel(Long id);
    List<HotelDTO> findHotelsByCity(String city);
}