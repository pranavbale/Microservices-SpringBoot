package com.pranavbale.user.service.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    private UUID ratingId;
    private UUID userId;
    private UUID hotelId;
    private Integer rating;
    private String feedBack;

}
