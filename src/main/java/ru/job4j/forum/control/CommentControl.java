package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.service.CommentService;

@Controller
public class CommentControl {
    private final CommentService commentService;

    public CommentControl(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/postComment")
    public String postComment(@RequestParam("idPost") int idPost, @ModelAttribute Comment comment ) {
        commentService.postComment(comment, idPost);
        return "redirect:/post?id=" + idPost;
    }
}
