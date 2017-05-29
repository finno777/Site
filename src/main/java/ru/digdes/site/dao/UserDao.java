package ru.digdes.site.dao;

import ru.digdes.site.model.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
public interface UserDao {

    Serializable save(User user);

    User findById(Serializable id);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getAll();
}
