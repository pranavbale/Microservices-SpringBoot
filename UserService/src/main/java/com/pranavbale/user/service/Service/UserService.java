package com.pranavbale.user.service.Service;

import com.pranavbale.user.service.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface UserService {

    // User Service Operation

    //save
    User saveUser(User user);

    // get All Users
    List<User> getAllUser();

    // get single User
    User getUser(UUID userId);

    // delete User
    String deleteUser(UUID userId);

    // Update user
    User updateUser(User user);
}
