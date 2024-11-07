package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/userPage")
    public String userPage() {
        return "user"; // Возвращает шаблон user.html
    }
    @GetMapping("/adminPage")
    public String adminPage() {
        return "admin";
    }
}

