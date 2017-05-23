package ru.digdes.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digdes.site.dao.UserDao;
import ru.digdes.site.model.User;
import ru.digdes.site.service.UserService;

import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(Long id) {

        return userDao.findById(id);
    }

    @Override
    public void addNewUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id){
        userDao.deleteUser(id);
    }


    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}

