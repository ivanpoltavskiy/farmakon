package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
