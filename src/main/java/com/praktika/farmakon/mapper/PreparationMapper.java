package com.praktika.farmakon.mapper;

import com.praktika.farmakon.dto.request.preparation.PreparationCreateRequest;
import com.praktika.farmakon.entity.Preparation;
import org.mapstruct.Mapper;

@Mapper
public interface PreparationMapper {
    Preparation fromDto(PreparationCreateRequest dro);
}
