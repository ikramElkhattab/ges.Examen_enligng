/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.User;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }

    public User findByEmailAndPassword(String email, String motDePasse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            user = (User) session.createQuery("FROM User u WHERE u.email = :email AND u.motDePasse = :mdp")
                    .setParameter("email", email)
                    .setParameter("mdp", motDePasse)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

}
