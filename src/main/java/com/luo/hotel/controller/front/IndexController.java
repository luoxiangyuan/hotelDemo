package com.luo.hotel.controller.front;


import com.luo.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.PostMapping;
//import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    HotelService hotelSearchService;

    @GetMapping("")
    public String index(){return "/index";}

/*    @PostMapping("")
    public ModelAndView goHtml(@Param("hotel_city")String hotel_city,
                               @Param("hotel_name")String hotel_name){
        ModelAndView model = new ModelAndView("hotels_display");
        List<Hotel> hotels = hotelSearchService.getHotelListByCityAndName(hotel_city,hotel_name);
        model.addObject("HotelList",hotels);
        return model;
    }*/
}
