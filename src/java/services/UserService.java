/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.UserDao;
import entites.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class UserService implements IService<User> {

    private final UserDao ud;

    public UserService() {
        this.ud = new UserDao();
    }

    @Override
    public boolean create(User o) {
        return ud.create(o);
    }

    @Override
    public boolean update(User o) {
        return ud.update(o);
    }

    @Override
    public boolean delete(User o) {
        return ud.delete(o);
    }

    @Override
    public List<User> findAll() {
        return ud.findAll();
    }

    @Override
    public User findById(int id) {
        return ud.findById(id);
    }

    public User findByEmail(String email) {
    Session session = null;
    Transaction tx = null;
    User user = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        user = (User) session
                .getNamedQuery("User.findByEmail")
                .setParameter("email", email)
                .uniqueResult();

        tx.commit();
    } catch (Exception e) {
        if (tx != null) tx.rollback();
    } finally {
        if (session != null) session.close();
    }

    return user;
}

    
}