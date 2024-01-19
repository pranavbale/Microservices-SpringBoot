package com.pranavbale.hotel.service;

import com.pranavbale.hotel.entity.Hotel;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    Hotel addHotel(Hotel hotel);

    Hotel getHotel(UUID hotelId);

    List<Hotel> getAllHotel();

    Hotel updateHotel(Hotel hotel);

    String deleteHotel(UUID hotelId);
}
