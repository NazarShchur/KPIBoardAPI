package ua.kpi.tef.apeps.kpiboardapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;
import ua.kpi.tef.apeps.kpiboardapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping("/userlist")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
