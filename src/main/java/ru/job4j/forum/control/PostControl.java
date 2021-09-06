package ru.job4j.forum.control;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;

import java.util.List;

@Controller
public class PostControl {
    private final PostService posts;
    private final UserRepository userRepository;
    private final CommentService commentService;

    public PostControl(PostService posts, UserRepository userRepository, CommentService commentService) {
        this.posts = posts;
        this.userRepository = userRepository;
        this.commentService = commentService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "forum/create";
    }

    @GetMapping("/edit")
    public String showPost(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findPostById(id));
        return "forum/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        post.setUser(user);
        posts.createOrUpdatePost(post);
        return "redirect:/";
    }

    @GetMapping("/post")
    public String post(@RequestParam("id") int id, Model model) {
        List<Comment> comments = commentService.getComments(id);
        System.out.println( posts.findPostById(id));
        model.addAttribute("post", posts.findPostById(id));
        model.addAttribute("comments", comments);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "forum/post";
    }
}
