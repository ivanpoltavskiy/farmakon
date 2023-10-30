package com.praktika.farmakon.mapper;

import com.praktika.farmakon.dto.request.order.OrderCreateRequest;
import com.praktika.farmakon.dto.request.order.OrderUpdateRequest;
import com.praktika.farmakon.dto.response.order.OrderResponse;
import com.praktika.farmakon.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    Order fromDto(OrderCreateRequest dto);
    Order fromDto(OrderUpdateRequest dto);
    OrderResponse toDto(Order entity);
    List<OrderResponse> toDtos(List<Order> entities);
}
