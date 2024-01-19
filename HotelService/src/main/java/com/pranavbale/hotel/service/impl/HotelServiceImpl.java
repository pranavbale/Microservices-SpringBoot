package com.pranavbale.hotel.service.impl;

import com.pranavbale.hotel.entity.Hotel;
import com.pranavbale.hotel.exception.HotelNOtFoundException;
import com.pranavbale.hotel.repository.HotelRepository;
import com.pranavbale.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(UUID hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new HotelNOtFoundException("hotel not found with id : " + hotelId));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public String deleteHotel(UUID hotelId) {
        hotelRepository.delete(getHotel(hotelId));
        return "hotel deleted Successfully id : " + hotelId;
    }
}
