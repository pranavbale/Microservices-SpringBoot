package com.pranavbale.user.service.Repository;

import com.pranavbale.user.service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
