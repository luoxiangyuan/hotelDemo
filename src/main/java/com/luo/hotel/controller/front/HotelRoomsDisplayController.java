package com.luo.hotel.controller.front;

import com.luo.hotel.domain.Hotel;
import com.luo.hotel.domain.HotelRoom;
import com.luo.hotel.service.HotelRoomService;
import com.luo.hotel.service.HotelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/rooms_display")
public class HotelRoomsDisplayController {
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelService hotelService;

    @GetMapping("")
    public String getHtml(){
        return "/rooms_display";
    }

    @PostMapping("")
    public Model showRoomList(HttpServletRequest request, @Param("hotel_id") String hotel_id, Model model){
        HttpSession session = request.getSession();
        List<HotelRoom> rooms = hotelRoomService.getRoomListByHotelId(hotel_id);
        Hotel hotel = hotelService.getHotelById(hotel_id);
        model.addAttribute("RoomList",rooms);
        model.addAttribute("HotelObject",hotel);
        return model;
    }

}
