package com.pranavbale.rating.service;

import com.pranavbale.rating.entity.Rating;

import java.util.List;
import java.util.UUID;

public interface RatingService {

    Rating create(Rating rating);

    Rating get(UUID ratingId);

    List<Rating> getAll();

    String delete(UUID ratingId);

    Rating update(Rating rating);

    List<Rating> getRatingByHotelId(UUID hotelId);

    List<Rating> getRatingByUserId(UUID userId);
}
