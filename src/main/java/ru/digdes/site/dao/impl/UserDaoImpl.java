package ru.digdes.site.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.digdes.site.dao.UserDao;
import ru.digdes.site.model.User;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(User user){
        return getSession().save(user);
    }
    @Override
    public User findById(final  Serializable id){return getSession().get(User.class, id);}

    @Override
    public void deleteUser(long id) {
        User user=findById(id);
        if(user!= null)
            getSession().delete(user);
    }

    @Override
    public void updateUser(User user){
        User userToUpdate=findById(user.getId());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        getSession().update(userToUpdate);
    }


    @Override
    public List<User> getAll() {
        return getSession().createCriteria(User.class).list();
    }
}
