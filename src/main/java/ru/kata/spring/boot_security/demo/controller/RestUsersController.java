package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestUsersController {

    @GetMapping("/user")
    public Map<String, Object> userPage(@AuthenticationPrincipal User userAuth) {
        Map<String, Object> response = new HashMap<>();
        response.put("userAuth", userAuth);
        return response;
    }
}