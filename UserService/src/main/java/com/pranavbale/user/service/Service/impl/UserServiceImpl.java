package com.pranavbale.user.service.Service.impl;

import com.pranavbale.user.service.Entity.Hotel;
import com.pranavbale.user.service.Entity.Rating;
import com.pranavbale.user.service.Entity.User;
import com.pranavbale.user.service.Repository.UserRepository;
import com.pranavbale.user.service.Service.UserService;
import com.pranavbale.user.service.exception.ResourceNotFountException;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(UUID userId) {
        // get the user form the database with the help of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFountException("User is not found on the server " + userId));

        // fetch rating of above user form the RATING SERVICE
        // 127.0.0.1:8083/rating/user/0e7a84d4-293d-4be3-9f4c-fce0ac008d31
         Rating[] ratingsArrayForUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(),  Rating[].class);

         // convert a array into list
        List<Rating> ratingForUser = Arrays.stream(ratingsArrayForUser).toList();
         // set the hotel for each rating
        List<Rating> ratingList = ratingForUser.stream().map(rating -> {

            // api call to hotel service to get the hotel info
            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/get/" + rating.getHotelId(),  Hotel.class);
            Hotel hotel = hotelResponseEntity.getBody();
            logger.info("Response Entity get Status code {}", hotelResponseEntity.getStatusCode());
            // set the hotel to rating 
            rating.setHotel(hotel);
            // return a rating
            return rating;
        }).collect(Collectors.toList());

         logger.info("{} ", ratingList);
         user.setRatings(ratingList);
        return user;
    }

    @Override
    public String deleteUser(UUID userId) {
        User user = getUser(userId);
        userRepository.delete(user);
        return "User deleted successfully " + userId;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
