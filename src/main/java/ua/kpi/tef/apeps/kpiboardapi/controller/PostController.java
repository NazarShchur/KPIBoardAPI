package ua.kpi.tef.apeps.kpiboardapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.tef.apeps.kpiboardapi.entity.Post;
import ua.kpi.tef.apeps.kpiboardapi.service.PostService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping
    public Post savePost(Post post) {
        return service.save(post);
    }

    @PutMapping
    public Post updatePost(Post post) {
        return service.update(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return service.findAll();
    }
}
