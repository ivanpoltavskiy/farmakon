package com.praktika.farmakon.repository;

import com.praktika.farmakon.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Boolean existsCategoryById(Long id);
}
