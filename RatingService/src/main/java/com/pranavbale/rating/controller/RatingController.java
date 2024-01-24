package com.pranavbale.rating.controller;


import com.pranavbale.rating.entity.Rating;
import com.pranavbale.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/find/{ratingId}")
    private ResponseEntity<Rating> findRating(@PathVariable UUID ratingId) {
        return new ResponseEntity<>(ratingService.get(ratingId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    private ResponseEntity<List<Rating>> findAll() {
        return  new ResponseEntity<>(ratingService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<Rating> create( @RequestBody Rating rating) {
        return  new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    private ResponseEntity<Rating> update(@RequestBody Rating rating) {
        return  new ResponseEntity<>(ratingService.update(rating), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ratingId}")
    private ResponseEntity<String> delete(@PathVariable UUID ratingId) {
        return new ResponseEntity<>(ratingService.delete(ratingId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    private ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable UUID userId) {
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    private ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable UUID hotelId) {
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
    }
}
