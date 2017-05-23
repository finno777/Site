package ru.digdes.site.service;

import ru.digdes.site.model.User;

import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
public interface UserService {
    User getUser(Long id);

    void updateUser(User user);

    void addNewUser(User user);

    void deleteUser(Long id);

    List<User> getAll();
}
