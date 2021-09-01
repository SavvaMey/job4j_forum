package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService implements PostStore {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger id = new AtomicInteger(1);

    public PostService() {
        Post post = Post.of("Продаю машину ладу 01.");
        post.setId(1);
        posts.put(id.getAndIncrement(), post);
    }

    @Override
    public List<Post> getAllPost() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post findPostById(int id) {
        return posts.getOrDefault(id, null);
    }

    @Override
    public void createOrUpdatePost(Post post) {
        int idPost;
        if (post.getId() == 0) {
            idPost = id.getAndIncrement();
            post.setId(idPost);
        } else {
            idPost = post.getId();
        }

        posts.put(idPost, post);
        System.out.println(idPost + " " + post.getId());
    }
}


