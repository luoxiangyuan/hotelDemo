package com.luo.hotel.service;

import com.luo.hotel.domain.HotelRoom;
import com.luo.hotel.mapper.HotelRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelRoomService {
    @Autowired
    HotelRoomMapper roomMapper;

    public List<HotelRoom> getRoomListByHotelId(String hotel_id){
        return roomMapper.getHotelRoomListByHotelId(hotel_id);
    }

    public HotelRoom getRoomByHotelRoomId(String hotel_id) {
        return roomMapper.getHotelRoomByHoteRoomlId(hotel_id);
    }
}
