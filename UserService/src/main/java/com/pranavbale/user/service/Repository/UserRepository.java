package com.pranavbale.user.service.Repository;

import com.pranavbale.user.service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
