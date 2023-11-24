package com.praktika.farmakon.controller;

import com.praktika.farmakon.dto.request.auth.LoginRequest;
import com.praktika.farmakon.dto.request.auth.RegisterRequest;
import com.praktika.farmakon.dto.response.JwtResponse;
import com.praktika.farmakon.mapper.UserMapper;
import com.praktika.farmakon.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserMapper userMapper;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@Valid @RequestBody RegisterRequest register) {
        return ResponseEntity.ok(authService.register(register));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest login) {
        return ResponseEntity.ok(authService.login(login));
    }

}
