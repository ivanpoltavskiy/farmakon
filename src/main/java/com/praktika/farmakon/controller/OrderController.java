package com.praktika.farmakon.controller;

import com.praktika.farmakon.repository.UserRepository;
import com.praktika.farmakon.service.OrderService;
import com.praktika.farmakon.service.UserService;
import lombok.RequiredArgsConstructor;
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
    private final UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestParam Long preparationId, @AuthenticationPrincipal UserDetails user){
      orderService.addToCard(preparationId, userService.findUserByEmail(user.getUsername()));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/ending")
    public ResponseEntity<Void> endingOrder(@RequestParam Long orderId){
        orderService.endingOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
