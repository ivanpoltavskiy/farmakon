package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.Order;
import com.praktika.farmakon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.user = :user AND o.completed = false")
    Optional<Order> findOrderByCompletedIsFalse(@Param("user") User user);
}
