package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestAdminsController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin")
    public Map<String, Object> userPage(@AuthenticationPrincipal User userAuth) {
        Map<String, Object> response = new HashMap<>();
        response.put("userAuth", userAuth);
        return response;
    }

    // Получение списка всех пользователей
    @GetMapping("/users")
    public List<User> getAllUsers(@AuthenticationPrincipal User userAuth) {
        return userService.getAllUsers(); // Возвращаем список всех пользователей
    }

    // Сохранение или обновление пользователя
    @PostMapping("/users")
    public void saveOrUpdateUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user); // Сохраняем или обновляем пользователя
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id); // Устанавливаем ID, чтобы он совпадал с путём
        userService.saveOrUpdateUser(user); // Обновляем пользователя
        return ResponseEntity.ok(user); // Возвращаем обновленного пользователя
    }


    // Получение информации о пользователе для редактирования
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id); // Возвращаем пользователя по ID
    }


    // Удаление пользователя
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id); // Удаляем пользователя по ID
    }

    // Получение всех ролей
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll(); // Возвращаем список всех ролей
    }
}
