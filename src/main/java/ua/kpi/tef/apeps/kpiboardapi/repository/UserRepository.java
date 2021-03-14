package ua.kpi.tef.apeps.kpiboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
