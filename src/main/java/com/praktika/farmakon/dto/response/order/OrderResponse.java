package com.praktika.farmakon.dto.response.order;

import com.praktika.farmakon.dto.response.preparation.PreparationResponse;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private Long number;
    private Long userId;
    private boolean completed;
    private List<PreparationResponse> preparations;
}
