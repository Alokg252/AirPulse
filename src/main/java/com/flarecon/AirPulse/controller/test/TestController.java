package com.flarecon.AirPulse.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping
    public String takeConfirmation() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("login user is {}", name);
        return String.format("welcome %s !!", name);
    }
}
