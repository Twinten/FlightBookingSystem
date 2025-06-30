package com.example.demo.mapper;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-30T22:47:23+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelDTO toDTO(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setId( hotel.getId() );
        hotelDTO.setName( hotel.getName() );
        hotelDTO.setCity( hotel.getCity() );
        hotelDTO.setAddress( hotel.getAddress() );
        hotelDTO.setRooms( roomListToRoomDTOList( hotel.getRooms() ) );

        afterHotelMapping( hotel, hotelDTO );

        return hotelDTO;
    }

    @Override
    public Hotel toEntity(HotelDTO hotelDTO) {
        if ( hotelDTO == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setName( hotelDTO.getName() );
        hotel.setCity( hotelDTO.getCity() );
        hotel.setAddress( hotelDTO.getAddress() );

        return hotel;
    }

    @Override
    public RoomDTO toRoomDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId( room.getId() );
        roomDTO.setType( room.getType() );
        roomDTO.setPrice( room.getPrice() );
        roomDTO.setAvailable( room.getAvailable() );
        roomDTO.setHotelId( roomHotelId( room ) );

        afterRoomMapping( room, roomDTO );

        return roomDTO;
    }

    @Override
    public void updateHotelFromDTO(HotelDTO hotelDTO, Hotel hotel) {
        if ( hotelDTO == null ) {
            return;
        }

        if ( hotelDTO.getName() != null ) {
            hotel.setName( hotelDTO.getName() );
        }
        if ( hotelDTO.getCity() != null ) {
            hotel.setCity( hotelDTO.getCity() );
        }
        if ( hotelDTO.getAddress() != null ) {
            hotel.setAddress( hotelDTO.getAddress() );
        }
    }

    @Override
    public List<HotelDTO> toDTOList(List<Hotel> hotels) {
        if ( hotels == null ) {
            return null;
        }

        List<HotelDTO> list = new ArrayList<HotelDTO>( hotels.size() );
        for ( Hotel hotel : hotels ) {
            list.add( toDTO( hotel ) );
        }

        return list;
    }

    @Override
    public List<RoomDTO> toRoomDTOList(List<Room> rooms) {
        if ( rooms == null ) {
            return null;
        }

        List<RoomDTO> list = new ArrayList<RoomDTO>( rooms.size() );
        for ( Room room : rooms ) {
            list.add( roomToRoomDTO( room ) );
        }

        return list;
    }

    protected List<RoomDTO> roomListToRoomDTOList(List<Room> list) {
        if ( list == null ) {
            return null;
        }

        List<RoomDTO> list1 = new ArrayList<RoomDTO>( list.size() );
        for ( Room room : list ) {
            list1.add( toRoomDTO( room ) );
        }

        return list1;
    }

    private Long roomHotelId(Room room) {
        if ( room == null ) {
            return null;
        }
        Hotel hotel = room.getHotel();
        if ( hotel == null ) {
            return null;
        }
        Long id = hotel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected RoomDTO roomToRoomDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId( room.getId() );
        roomDTO.setType( room.getType() );
        roomDTO.setPrice( room.getPrice() );
        roomDTO.setAvailable( room.getAvailable() );

        afterRoomMapping( room, roomDTO );

        return roomDTO;
    }
}
