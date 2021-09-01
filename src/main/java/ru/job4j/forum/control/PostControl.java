package ru.job4j.forum.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "forum/create";
    }

    @GetMapping("/edit")
    public String showPost(@RequestParam("id") int id, Model model) {
//        System.out.println(posts.findPostById(id));
        System.out.println(posts.findPostById(id).getId() + " id" + id);
        model.addAttribute("post", posts.findPostById(id));
        return "forum/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        System.out.println(post.getId() + " " + post.getName());
        posts.createOrUpdatePost(post);
        return "redirect:/";
    }
}
