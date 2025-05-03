/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ExamenDao;
import entites.Etudiant;
import entites.Examen;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mapping.ExamenMapping;
import org.hibernate.Session;
import util.HibernateUtil;

public class ExamenService implements IService<Examen> {

    private final ExamenDao dao = new ExamenDao();

    @Override
    public boolean create(Examen o) {
        return dao.create(o);
    }

    @Override
    public boolean update(Examen o) {
        return dao.update(o);
    }

    @Override
    public boolean delete(Examen o) {
        return dao.delete(o);
    }

    @Override
    public List<Examen> findAll() {
        List<Examen> examens = dao.findAll();
    for (Examen e : examens) {
        e.getMatiere().getNom(); // force le chargement de matiere
    }
    return examens;
    }

    @Override
    public Examen findById(int id) {
        return dao.findById(id);
    }
    public Map<String, Long> countByMatiere() {
        Map<String, Long> resultMap = new HashMap<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Object[]> results = session.createQuery(ExamenMapping.COUNT_BY_MATIERE).list();
            for (Object[] row : results) {
                String matiereId = String.valueOf(row[0]);
                Long count = (Long) row[1];
                resultMap.put(matiereId, count);
            }
        } finally {
            session.close();
        }
        return resultMap;
    }
    public List<Examen> findByEtudiant(Etudiant etudiant) {
    return dao.findByEtudiant(etudiant);
}

}
