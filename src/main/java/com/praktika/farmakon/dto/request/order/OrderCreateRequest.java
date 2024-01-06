package com.praktika.farmakon.dto.request.order;

import com.praktika.farmakon.entity.Preparation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreateRequest {
    private List<Preparation> preparations;
    private boolean completed;
    private Long number;
}
