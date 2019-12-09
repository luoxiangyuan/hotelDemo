package com.luo.hotel.service;

import com.luo.hotel.domain.Log;
import com.luo.hotel.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogMapper logMapper;

    public void CreateLog(Log log){
        logMapper.createLog(log);
    }

    public List<Log> getLogsByHotelId(String hotel_id){
        return logMapper.getLogsByHotelId(hotel_id);
    }
}
