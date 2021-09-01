package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepo;

@Controller
public class RegControl {
    private final UserRepo users;

    public RegControl(UserRepo users) {
        this.users = users;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        return "reg";
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute User user) {
        return "reg";
    }
}
