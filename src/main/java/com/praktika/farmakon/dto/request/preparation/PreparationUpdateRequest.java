package com.praktika.farmakon.dto.request.preparation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreparationUpdateRequest {
    @NotNull(message = "Id cannot be null")
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Manufacturer cannot be null")
    private String manufacturer;
    @NotNull(message = "Description cannot be null")
    private String description;
    @NotNull(message = "Active substance cannot be null")
    private String activeSubstance;
    @NotNull(message = "Price cannot be null")
    @DecimalMin("0.01")
    private Double price;
    @NotBlank(message = "Instruction cannot be null")
    private String instruction;
    @NotNull(message = "Write a category")
    private Long categoryId;
}
