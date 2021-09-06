package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.*;

@Service
public class PostService  {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAllPost() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findPostById(int id) {
        return posts.findById(id).orElse(null);
    }

    public void createOrUpdatePost(Post post) {
        post.setCreated(new Date(System.currentTimeMillis()));
        posts.save(post);
    }
}


