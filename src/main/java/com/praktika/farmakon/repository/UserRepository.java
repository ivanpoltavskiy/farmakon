package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findUserByEmail(String email);
    Boolean existsUserByEmail(String email);
}
