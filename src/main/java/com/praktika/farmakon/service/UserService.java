package com.praktika.farmakon.service;

import com.praktika.farmakon.entity.User;
import com.praktika.farmakon.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Boolean existUserByEmail(String email){
        return userRepository.existsUserByEmail(email);
    }

    @Transactional
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
