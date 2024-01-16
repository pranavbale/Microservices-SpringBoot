package com.pranavbale.user.service.Service;

import com.pranavbale.user.service.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // User Service Operation

    //save
    User saveUser(User user);

    // get All Users
    List<User> getAllUser();

    // get single User
    User getUser(String userId);

    // delete User
    String deleteUser(String userId);

    // Update user
    User updateUser(User user);
}
