package com.praktika.farmakon.controller;

import com.praktika.farmakon.dto.request.category.CategoryCreateRequest;
import com.praktika.farmakon.dto.request.category.CategoryUpdateRequest;
import com.praktika.farmakon.dto.response.category.CategoryResponse;
import com.praktika.farmakon.mapper.CategoryMapper;
import com.praktika.farmakon.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategory(){
        return new ResponseEntity<>(categoryMapper.toDtos(categoryService.findAllCategory()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest){
        return new ResponseEntity<>(categoryMapper.toDto(categoryService.createCategory(categoryMapper.fromDto(categoryCreateRequest))), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> updateCategory(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest){
        return new ResponseEntity<>(categoryMapper.toDto(categoryService.updateCategory(categoryMapper.fromDto(categoryUpdateRequest))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
