package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepo implements UserStore{
    private final List<User> users = new ArrayList<>();

    public UserRepo() {
        users.add(User.of("USER", "123"));
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
