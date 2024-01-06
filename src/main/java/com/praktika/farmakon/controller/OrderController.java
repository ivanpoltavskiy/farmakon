package com.praktika.farmakon.controller;

import com.praktika.farmakon.dto.request.order.OrderCreateRequest;
import com.praktika.farmakon.dto.response.order.OrderResponse;
import com.praktika.farmakon.mapper.OrderMapper;
import com.praktika.farmakon.service.OrderService;
import com.praktika.farmakon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final OrderMapper orderMapper;

//    @PostMapping("/add")
//    public ResponseEntity<Void> addToCart(@RequestParam Long preparationId, @AuthenticationPrincipal UserDetails user){
//      orderService.addToCard(preparationId, userService.findUserByEmail(user.getUsername()));
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("setOrder")
    public ResponseEntity<OrderResponse> takeNewOrder(@RequestBody OrderCreateRequest createRequest, @AuthenticationPrincipal UserDetails user){
        return new ResponseEntity<>(orderMapper.toDto(orderService.takeNewOrder(orderMapper.fromDto(createRequest), userService.findUserByEmail(user.getUsername()))), HttpStatus.OK);
    }

    @PatchMapping("/ending")
    public ResponseEntity<Void> endingOrder(@RequestParam Long orderId){
        orderService.endingOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
