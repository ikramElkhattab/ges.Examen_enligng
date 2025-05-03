/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.EtudiantDao;
import entites.Etudiant;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class EtudiantService implements IService<Etudiant> {

    private final EtudiantDao ed;

    public EtudiantService() {
        this.ed = new EtudiantDao();
    }

    @Override
    public boolean create(Etudiant o) {
        return ed.create(o);
    }

    @Override
    public boolean update(Etudiant o) {
        return ed.update(o);
    }

    @Override
    public boolean delete(Etudiant o) {
        return ed.delete(o);
    }

    @Override
    public List<Etudiant> findAll() {
        return ed.findAll();
    }

    @Override
    public Etudiant findById(int id) {
        return ed.findById(id);

    }

    public Etudiant findByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        Etudiant etudiant = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            etudiant = (Etudiant) session
                    .getNamedQuery("Etudiant.findByEmail")
                    .setParameter("email", email)
                    .uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return etudiant;
    }

}
