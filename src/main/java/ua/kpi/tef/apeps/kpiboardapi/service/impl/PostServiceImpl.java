package ua.kpi.tef.apeps.kpiboardapi.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.kpi.tef.apeps.kpiboardapi.entity.Post;
import ua.kpi.tef.apeps.kpiboardapi.repository.PostRepository;
import ua.kpi.tef.apeps.kpiboardapi.repository.UserRepository;
import ua.kpi.tef.apeps.kpiboardapi.security.jwt.JwtUser;
import ua.kpi.tef.apeps.kpiboardapi.service.PostService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final UserRepository urepository;

    @Override
    public Post save(Post post) {
        var author = (JwtUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setAuthor(urepository.findById(author.getId()).orElse(null));
        post.setDate(LocalDate.now());
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

    @Override
    public String uploadFile(MultipartFile file) {
        Map config = ObjectUtils.asMap(
                "cloud_name", "kpiboard",
                "api_key", "848773655955447",
                "api_secret", "0QdLasEGXDJ9B8Svbyu_Zcb3q7Y");
        Cloudinary cloudinary = new Cloudinary(config);
        var params = ObjectUtils.asMap(
                "public_id", "myfolder/" + file.getOriginalFilename(),
                "overwrite", true,
                "resource_type", "image"
        );
        Map up;
        try {
            up = cloudinary.uploader().upload(file.getBytes(), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (String)up.get("secure_url");
    }
}
