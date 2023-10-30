package com.praktika.farmakon.dto.request.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreateRequest {
    @NotNull(message = "Name cannot be null!")
    private String name;
}
