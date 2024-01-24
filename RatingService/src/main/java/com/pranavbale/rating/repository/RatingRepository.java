package com.pranavbale.rating.repository;

import com.pranavbale.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID> {

    List<Rating> findAllByUserId(UUID userId);

    List<Rating> findAllByHotelId(UUID hotelId);
}
