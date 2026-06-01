package com.flarecon.AirPulse.tools;

import com.flarecon.AirPulse.model.user.User;
import com.flarecon.AirPulse.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailTools {

    private final UserRepository userRepository;

    @Tool(description = "Return the authenticated user's full profile (id, uuid, name, username, gender, dateOfBirth, age, email). Returns null if not found.")
    public User getUserDetails() {
        return userRepository.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
    }

}
