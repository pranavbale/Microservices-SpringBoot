package com.pranavbale.rating.service.impl;

import com.pranavbale.rating.entity.Rating;
import com.pranavbale.rating.exception.RatingNotFoundException;
import com.pranavbale.rating.repository.RatingRepository;
import com.pranavbale.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating get(UUID ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()-> new RatingNotFoundException("Rating not found with RatingId : " + ratingId));
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public String delete(UUID ratingId) {
        ratingRepository.delete(get(ratingId));
        return "Rating deleted successfully " + ratingId;
    }

    @Override
    public Rating update(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByHotelId(UUID hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingByUserId(UUID userId) {
        return ratingRepository.findAllByUserId(userId);
    }
}
