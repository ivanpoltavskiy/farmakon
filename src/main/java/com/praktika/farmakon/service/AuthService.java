package com.praktika.farmakon.service;

import com.praktika.farmakon.config.JwtUtils;
import com.praktika.farmakon.dto.request.auth.LoginRequest;
import com.praktika.farmakon.dto.request.auth.RegisterRequest;
import com.praktika.farmakon.dto.response.JwtResponse;
import com.praktika.farmakon.entity.Role;
import com.praktika.farmakon.entity.User;
import com.praktika.farmakon.repository.RoleRepository;
import com.praktika.farmakon.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final RoleRepository  roleRepository;
    private final UserDetailsServiceCustom userDetailsService;

    public JwtResponse register(RegisterRequest registerRequest){
        if (userService.existUserByEmail(registerRequest.getEmail())){
            throw new RuntimeException("User is existed");
        }

        Role role = roleRepository.findById(registerRequest.getRoleId())
                .orElseThrow(()-> new RuntimeException("Role not found"));

        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .name(registerRequest.getName())
                .surname(registerRequest.getSurname())
                .dateOfBirthday(registerRequest.getDateOfBirthday())
                .roles(Collections.singleton(role))
                .build();

        userRepository.save(user);
        String jwtToken = jwtUtils.generateToken(user);

        return JwtResponse.builder()
                .token(jwtToken)
                .build();
    }

    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtUtils.generateToken(user);
        return JwtResponse.builder()
                .token(jwtToken)
                .build();
    }

}
