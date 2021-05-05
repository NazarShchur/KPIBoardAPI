package ua.kpi.tef.apeps.kpiboardapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kpi.tef.apeps.kpiboardapi.entity.Post;
import ua.kpi.tef.apeps.kpiboardapi.repository.PostRepository;
import ua.kpi.tef.apeps.kpiboardapi.service.PostService;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return repository.save(post);
    }

    @Override
    public void delete(Long id) {
        var post = findById(id);
        repository.delete(post);
    }

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
