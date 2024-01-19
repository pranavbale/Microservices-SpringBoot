package com.pranavbale.user.service.Controller;

import com.pranavbale.user.service.Entity.User;
import com.pranavbale.user.service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // get the unique user
    @GetMapping("get/{id}")
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
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CRETED);
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

}
