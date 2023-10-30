package com.praktika.farmakon.mapper;

import com.praktika.farmakon.dto.request.category.CategoryCreateRequest;
import com.praktika.farmakon.dto.request.category.CategoryUpdateRequest;
import com.praktika.farmakon.dto.response.category.CategoryResponse;
import com.praktika.farmakon.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryResponse toDto(Category entity);
    List<CategoryResponse> toDtos(List<Category> entities);
    Category fromDto(CategoryCreateRequest dto);
    Category fromDto(CategoryUpdateRequest dto);

}
