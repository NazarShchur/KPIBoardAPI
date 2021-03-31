package ua.kpi.tef.apeps.kpiboardapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.kpi.tef.apeps.kpiboardapi.entity.Role;
import ua.kpi.tef.apeps.kpiboardapi.entity.Status;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;
import ua.kpi.tef.apeps.kpiboardapi.repository.UserRepository;
import ua.kpi.tef.apeps.kpiboardapi.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public User register(User user) {
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
