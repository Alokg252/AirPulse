package com.flarecon.AirPulse.controller.user;

import com.flarecon.AirPulse.dto.user.UserDto;
import com.flarecon.AirPulse.model.user.User;
import com.flarecon.AirPulse.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody Map<String, String> request) {
        User user = new User();
        user.setEmail(request.get("email"));
        user.setUsername(request.get("username"));
        user.setName(request.get("name"));
        user.setPlainPassword(request.get("password"));
        user.setUuid(UUID.randomUUID().toString());

        return ResponseEntity.ok(new UserDto(userRepository.saveAndFlush(user)));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(new UserDto(userRepository.findByUsername(username).orElseThrow()));
    }

}
