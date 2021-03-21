package ua.kpi.tef.apeps.kpiboardapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;
import ua.kpi.tef.apeps.kpiboardapi.repository.UserRepository;
import ua.kpi.tef.apeps.kpiboardapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public User registerUser() {
        User user = new User();
        user.setUsername("Orest");
        return userService.register(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
}