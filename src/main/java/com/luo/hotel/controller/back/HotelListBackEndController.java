package com.luo.hotel.controller.back;


import com.luo.hotel.domain.Hotel;
import com.luo.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HotelListBackEndController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/hotelList")
    @ResponseBody
    public List<Hotel> getHotelList(HttpSession session){
        String adminId = (String) session.getAttribute("hotel_admin_id");
        return hotelService.getList(adminId);
    }
}
