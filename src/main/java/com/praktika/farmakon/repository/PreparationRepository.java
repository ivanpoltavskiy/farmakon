package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.Preparation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreparationRepository extends JpaRepository<Preparation, Long> {
    Optional<Preparation> findById(Long id, PageRequest pageRequest);
    Boolean existsPreparationById(Long id);
}

