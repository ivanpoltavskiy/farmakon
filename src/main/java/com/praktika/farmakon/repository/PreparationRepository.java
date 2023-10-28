package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.Preparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreparationRepository extends JpaRepository<Preparation, Long> {
}
