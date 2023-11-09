package com.praktika.farmakon.mapper;

import com.praktika.farmakon.dto.request.preparation.PreparationCreateRequest;
import com.praktika.farmakon.dto.request.preparation.PreparationUpdateRequest;
import com.praktika.farmakon.dto.response.preparation.PreparationResponse;
import com.praktika.farmakon.entity.Preparation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PreparationMapper {
    Preparation fromDto(PreparationCreateRequest dto);
    Preparation fromDto(PreparationUpdateRequest dto);
    PreparationResponse toDto(Preparation entity);
    List<PreparationResponse> toDtos(List<Preparation> entities);
}
