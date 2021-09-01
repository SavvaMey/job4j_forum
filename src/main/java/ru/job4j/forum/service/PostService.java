package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService implements PostStore {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    @Override
    public List<Post> getAllPost() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    @Override
    public Post findPostById(int id) {
        return posts.findById(id).orElse(null);
    }

    @Override
    public void createOrUpdatePost(Post post) {
        System.out.println(post.getDescription());
        post.setCreated(new Date(System.currentTimeMillis()));
       posts.save(post);
    }
}


