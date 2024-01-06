package com.praktika.farmakon.service;

import com.praktika.farmakon.entity.Order;
import com.praktika.farmakon.entity.User;
import com.praktika.farmakon.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PreparationService preparationService;
    private final OrderRepository orderRepository;


    public Order takeNewOrder(Order order, User user){
        order.setUser(user);
        order.setUserId(user.getId());
        return orderRepository.save(order);
    }

    public void endingOrder(Long orderId){
        Order currentOrder = orderRepository.getById(orderId);
        if (!currentOrder.isCompleted()){
            currentOrder.setCompleted(true);
        }
        orderRepository.save(currentOrder);
    }
//    public void takeNewOrder(Order order, User user){
//        Optional<Order> currentOrder = orderRepository.findOrderByCompletedIsFalse(user);
//        if (currentOrder.isEmpty()){
//            Order newOrder = createOrder(user);
//            newOrder.setPreparations(order.getPreparations());
//            orderRepository.save(newOrder);
//        }
//        else {
//            Order existingOrder = currentOrder.get();
//            existingOrder.getPreparations().add(preparationService.getPreparationById(preparationId));
//            orderRepository.save(existingOrder);
//        }
//    }
}
