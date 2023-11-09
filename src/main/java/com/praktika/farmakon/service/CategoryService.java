package com.praktika.farmakon.service;

import com.praktika.farmakon.entity.Category;
import com.praktika.farmakon.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not found"));
    }

    @Transactional
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Category category){
        if (!categoryRepository.existsCategoryById(category.getId())){
            throw new EntityNotFoundException("Category not found");
        }
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id){
        if (!categoryRepository.existsCategoryById(id)){
            throw new EntityNotFoundException("Category not found");
        }
        else {
            categoryRepository.deleteById(id);
        }
    }
}
