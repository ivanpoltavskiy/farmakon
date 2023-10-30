package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
