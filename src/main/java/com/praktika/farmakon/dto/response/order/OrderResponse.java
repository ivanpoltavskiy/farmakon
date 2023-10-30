package com.praktika.farmakon.dto.response.order;

import com.praktika.farmakon.entity.Preparation;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private Long number;
    private Long userId;
    private List<Preparation> preparations;
}
