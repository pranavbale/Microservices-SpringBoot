package com.pranavbale.hotel.controller;


import com.pranavbale.hotel.entity.Hotel;
import com.pranavbale.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    private ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    private ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{hotelId}")
    private ResponseEntity<String> deleteHotel(@PathVariable UUID hotelId) {
        return new ResponseEntity<>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
    }

    @GetMapping("/get/{hotelId}")
    private ResponseEntity<Hotel> getHotel(@PathVariable UUID hotelId) {
        return new ResponseEntity<>(hotelService.getHotel(hotelId), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<Hotel>> getAllHotel() {
        return new ResponseEntity<>(hotelService.getAllHotel(), HttpStatus.OK);
    }
}
