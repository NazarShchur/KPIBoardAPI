package ua.kpi.tef.apeps.kpiboardapi.service;

import ua.kpi.tef.apeps.kpiboardapi.entity.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);
    Post update(Post post);
    void delete(Long post);
    List<Post> findAll();
    Post findById(Long id);
}
