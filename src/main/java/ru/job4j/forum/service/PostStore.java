package ru.job4j.forum.service;

import ru.job4j.forum.model.Post;

import java.util.List;

public interface PostStore {
    List<Post> getAllPost();

    Post findPostById(int id);

    void createOrUpdatePost(Post post);


}
