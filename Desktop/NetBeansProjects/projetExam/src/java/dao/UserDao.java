/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    Session session = null;
    Transaction tx = null;
    User user = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        user = (User) session.createQuery("FROM User u WHERE u.email = :email AND u.motDePasse = :mdp")
                .setParameter("email", email)
                .setParameter("mdp", motDePasse)
                .uniqueResult();

        tx.commit();
    } catch (Exception e) {
        if (tx != null) tx.rollback(); // rollback propre
        e.printStackTrace();
        throw new RuntimeException("Erreur système : " + e.getMessage());
    } finally {
        if (session != null) session.close();
    }

    return user;
}


}
