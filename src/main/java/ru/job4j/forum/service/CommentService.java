package ru.job4j.forum.service;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.CommentRepository;
import ru.job4j.forum.repository.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository posts;

    public CommentService(CommentRepository commentRepository, PostRepository posts) {
        this.commentRepository = commentRepository;
        this.posts = posts;
    }

    public List<Comment> getComments(int id) {
        return commentRepository.findByPostId(id);
    }

    public void postComment(Comment comment, int idPost) {
        Optional<Post> post = posts.findById(idPost);
        comment.setCreated(new Date(System.currentTimeMillis()));
        if (post.isPresent()) {
            comment.setPost(post.get());
            commentRepository.save(comment);
        }
    }
}
