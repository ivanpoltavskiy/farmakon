package com.praktika.farmakon.service;

import com.praktika.farmakon.entity.Order;
import com.praktika.farmakon.entity.User;
import com.praktika.farmakon.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PreparationService preparationService;
    private final OrderRepository orderRepository;

    public Order createOrder(User user){

        return Order.builder()
                .completed(false)
                .user(user)
                .preparations(Collections.emptyList())
                .build();
    }

    public void addToCard(Long preparationId, User user){
        Optional<Order> currentOrder = orderRepository.findOrderByCompletedIsFalse(user);
        if (currentOrder.isEmpty()){
            Order newOrder = createOrder(user);
            newOrder.setPreparations(Collections.singletonList(preparationService.getPreparationById(preparationId)));
            orderRepository.save(newOrder);
        }
        else {
            Order existingOrder = currentOrder.get();
            existingOrder.getPreparations().add(preparationService.getPreparationById(preparationId));
            orderRepository.save(existingOrder);
        }
    }

    public void endingOrder(Long orderId){
        Order currentOrder = orderRepository.getById(orderId);
        if (!currentOrder.isCompleted()){
            currentOrder.setCompleted(true);
        }
        orderRepository.save(currentOrder);
    }
}
