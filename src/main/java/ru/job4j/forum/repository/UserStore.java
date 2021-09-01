package ru.job4j.forum.repository;

import ru.job4j.forum.model.User;

public interface UserStore {
    public void save(User user);
}
