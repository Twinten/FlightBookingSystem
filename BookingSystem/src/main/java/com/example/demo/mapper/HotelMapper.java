package com.example.demo.mapper;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HotelMapper {

    // Маппинг Hotel -> HotelDTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "rooms", source = "rooms", qualifiedByName = "mapRooms")
    HotelDTO toDTO(Hotel hotel);

    // Маппинг HotelDTO -> Hotel (для создания)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    Hotel toEntity(HotelDTO hotelDTO);

    // Маппинг Room -> RoomDTO
    @Named("mapRooms")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "available", source = "available")
    @Mapping(target = "hotelId", source = "hotel.id")
    RoomDTO toRoomDTO(Room room);

    // Обновление Hotel из HotelDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    void updateHotelFromDTO(HotelDTO hotelDTO, @MappingTarget Hotel hotel);

    // Маппинг списка отелей
    List<HotelDTO> toDTOList(List<Hotel> hotels);

    // Маппинг списка номеров
    List<RoomDTO> toRoomDTOList(List<Room> rooms);

    // Дефолтные методы для кастомной логики
    @AfterMapping
    default void afterHotelMapping(Hotel hotel, @MappingTarget HotelDTO hotelDTO) {
        if (hotel.getRooms() != null) {
            hotelDTO.setRooms(toRoomDTOList(hotel.getRooms()));
        }
    }

    @AfterMapping
    default void afterRoomMapping(Room room, @MappingTarget RoomDTO roomDTO) {
        if (room.getHotel() != null) {
            roomDTO.setHotelId(room.getHotel().getId());
        }
    }
}