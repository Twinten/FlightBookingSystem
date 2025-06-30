package com.example.demo.service;

import com.example.demo.dto.HotelDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.HotelMapper;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public List<HotelDTO> findAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO findHotelById(Long id) {
        return hotelRepository.findById(id)
                .map(hotelMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
    }

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Hotel hotel = hotelMapper.toEntity(hotelDTO);
        Hotel savedHotel = hotelRepository.save(hotel);
        return hotelMapper.toDTO(savedHotel);
    }

    @Override
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));

        hotelMapper.updateHotelFromDTO(hotelDTO, existingHotel);
        Hotel updatedHotel = hotelRepository.save(existingHotel);
        return hotelMapper.toDTO(updatedHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new NotFoundException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelDTO> findHotelsByCity(String city) {
        return hotelRepository.findByCity(city).stream()
                .map(hotelMapper::toDTO)
                .collect(Collectors.toList());
    }
}