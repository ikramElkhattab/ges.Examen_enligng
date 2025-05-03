/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ResultatDao;
import entites.Etudiant;
import entites.Resultat;
import entites.ResultatID;
import java.util.List;

public class ResultatService {

    private final ResultatDao dao;

    public ResultatService() {
        this.dao = new ResultatDao();
    }

    public boolean create(Resultat r) {
        return dao.create(r);
    }

    public boolean update(Resultat r) {
        return dao.update(r);
    }

    public boolean delete(Resultat r) {
        return dao.delete(r);
    }

    public List<Resultat> findAll() {
        return dao.findAll();
    }

    public Resultat findById(int id) {
        return dao.findById(id);
    }
    public Resultat findById(ResultatID id) {
        return dao.findById(id);
    }
 public List<Resultat> findResultatsByEtudiant(Etudiant etudiant) {
    return dao.findByEtudiant(etudiant);
}


}


