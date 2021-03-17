package ua.kpi.tef.apeps.kpiboardapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;
import ua.kpi.tef.apeps.kpiboardapi.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestController {
    private final UserRepository repository;
    @PostMapping
    public User saveOrest() {
        User user = new User();
        user.setName("Orest");
        return repository.save(user);
    }

    @GetMapping
    public List<User> getOrests() {
        return repository.findAll();
    }
}