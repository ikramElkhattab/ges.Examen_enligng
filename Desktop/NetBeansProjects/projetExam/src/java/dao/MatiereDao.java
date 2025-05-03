/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Etudiant;
import entites.Matiere;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class MatiereDao implements IDao<Matiere> {

    @Override
    public boolean create(Matiere o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean delete(Matiere o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(Matiere o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public List<Matiere> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Matiere> matieres = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            matieres = session.createQuery("from Matiere").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return matieres;
    }

    @Override
    public Matiere findById(int id) {
        Session session = null;
        Transaction tx = null;
        Matiere matiere = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            matiere = (Matiere) session.get(Matiere.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return matiere;
    }

    public List<Matiere> findByEtudiant(Etudiant etudiant) {
        Session session = null;
        Transaction tx = null;
        List<Matiere> matieres = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(
                    "SELECT DISTINCT r.examen.matiere FROM Resultat r WHERE r.etudiant.id = :id"
            );
            query.setParameter("id", etudiant.getId());
            matieres = query.list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return matieres;
    }

}
