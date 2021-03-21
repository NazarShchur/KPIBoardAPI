package ua.kpi.tef.apeps.kpiboardapi.service;

import ua.kpi.tef.apeps.kpiboardapi.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findById(Long id);

    User findByUserName(String username);
}
