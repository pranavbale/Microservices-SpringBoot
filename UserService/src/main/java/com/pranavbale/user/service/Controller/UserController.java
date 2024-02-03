package com.pranavbale.user.service.Controller;

import com.pranavbale.user.service.Entity.User;
import com.pranavbale.user.service.Service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    // get the unique user
    // in a circuit breaker we add name for configuration
    // in a circuit breaker we use a fallbackMethod if any service is open then this method call and return type must be same
    @GetMapping("get/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    private ResponseEntity<User> getUser(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    // get all users
    @GetMapping("/getAll")
    private ResponseEntity<List<User>> getAllUser() {
        return  new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    // create user
    @PostMapping("/create")
    private ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // update user
    @PutMapping("/update")
    private ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    // delete user
    @DeleteMapping("/delete/{userId}")
    private ResponseEntity<String> deleteUser(@PathVariable UUID userId) {
        String msg = userService.deleteUser(userId);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    // rating hotel fall back method for circuit breaker
    // if any dependent service is open then this function get call
    public ResponseEntity<User> ratingHotelFallBack(UUID id, Exception ex) {
        logger.info("Fall Back is executed because service is down : ", ex.getMessage());
        User user = User.builder()
                .userId(UUID.randomUUID())
                .name("Dummy Name")
                .email("dummyemail@gmail.com")
                .about("The dependent service is down")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
