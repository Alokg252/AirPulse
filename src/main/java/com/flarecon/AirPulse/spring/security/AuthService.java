package com.flarecon.AirPulse.spring.security;

import com.flarecon.AirPulse.model.user.User;
import com.flarecon.AirPulse.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public boolean authenticateUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return user.verifyPassword(password);
        }
        return false;
    }

    public boolean authenticateUsername(String username) {
        return username != null && userRepository.existsByUsername(username);
    }

}
