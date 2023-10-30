package com.praktika.farmakon.dto.response.preparation;

import lombok.Data;

@Data
public class PreparationResponse {
    private Long id;
    private String name;
    private String manufacturer;
    private String description;
    private String activeSubstance;
    private Double price;
    private String instruction;
    private Long categoryId;
}
