package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveOrUpdateUser (User user);
    void deleteUser(long id);
    User getUser(long id);
}
