package ua.kpi.tef.apeps.kpiboardapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;
import ua.kpi.tef.apeps.kpiboardapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
        var user = userService.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}