package com.flarecon.AirPulse.spring.security;

import com.flarecon.AirPulse.Constants;
import com.flarecon.AirPulse.utils.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        if (authService.authenticateUser(username, password)) {
            String token = jwtUtil.generateToken(username);
            return Map.of("token", token);
        }

        throw new AuthenticationCredentialsNotFoundException("wrong username or password");
    }
}
