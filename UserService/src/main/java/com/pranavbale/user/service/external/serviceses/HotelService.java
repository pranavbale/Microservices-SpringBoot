package com.pranavbale.user.service.external.serviceses;

import com.pranavbale.user.service.Entity.Hotel;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/get/{id}")
    Hotel getHotel(@PathVariable UUID id);
}
