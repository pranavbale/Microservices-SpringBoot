package com.pranavbale.user.service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private UUID hotelId;
    private String name;
    private String location;
    private String about;
}