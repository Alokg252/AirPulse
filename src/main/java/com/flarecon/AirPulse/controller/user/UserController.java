package com.flarecon.AirPulse.controller.user;

import com.flarecon.AirPulse.model.user.User;
import com.flarecon.AirPulse.model.user.UserGender;
import com.flarecon.AirPulse.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> request) {
        User user = new User();
        user.setEmail(request.get("email"));
        user.setUsername(request.get("username"));
        user.setName(request.get("name"));
        user.setGender(UserGender.valueOf(request.get("gender")));
        user.setDob(LocalDate.parse(request.get("dob")));
        user.setPlainPassword(request.get("password"));
        user.setUuid(UUID.randomUUID().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.saveAndFlush(user));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return ResponseEntity.ok(user);
    }

}
