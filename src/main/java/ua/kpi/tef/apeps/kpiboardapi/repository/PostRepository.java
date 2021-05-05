package ua.kpi.tef.apeps.kpiboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.tef.apeps.kpiboardapi.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
