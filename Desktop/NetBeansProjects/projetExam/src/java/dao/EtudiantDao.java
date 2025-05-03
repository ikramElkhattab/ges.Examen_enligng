/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Etudiant;
import entites.Examen;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author a
 */
public class EtudiantDao implements IDao<Etudiant>{

    @Override
    public boolean create(Etudiant o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(Etudiant o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean update(Etudiant o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public List<Etudiant> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Etudiant> etudiants = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            etudiants = session.createQuery("from Etudiant").list();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etudiants;
    }

    @Override
    public Etudiant findById(int id) {
        Session session = null;
        Transaction tx = null;
        Etudiant etudiant = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            etudiant = (Etudiant) session.get(Etudiant.class, id);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etudiant;
    }
    public List<Etudiant> findBetweenDate(Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Etudiant> etudiants = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            etudiants = session.getNamedQuery("findBetweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
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
        return etudiants;
    }
    public List<Examen> findExamen(Etudiant e) {
    Session session = null;
    Transaction tx = null;
    List<Examen> examens = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        examens = session.getNamedQuery("findExamenByUserId")  // Mettre à jour le nom ici
                         .setParameter("id", e.getId())
                         .list();
        tx.commit();
    } catch (HibernateException ex) {
        if (tx != null) tx.rollback();
    } finally {
        if (session != null) session.close();
    }
    return examens;
}

    public Etudiant findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


