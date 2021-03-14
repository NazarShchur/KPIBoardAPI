package ua.kpi.tef.apeps.kpiboardapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;
import ua.kpi.tef.apeps.kpiboardapi.repository.UserRepository;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestController {
    private final UserRepository repository;
    @GetMapping
    public String test() {
        User user = new User();
        user.setName("Orest");
        repository.save(user);
        return "Hello World";
    }
}