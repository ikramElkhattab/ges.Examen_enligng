/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.MatiereDao;
import entites.Etudiant;
import entites.Matiere;
import java.util.List;

/**
 *
 * @author hp
 */
public class MatiereService implements IService<Matiere> {

    private final MatiereDao md;

    public MatiereService() {
        this.md = new MatiereDao();
    }

    @Override
    public boolean create(Matiere o) {
        return md.create(o);
    }

    @Override
    public boolean update(Matiere o) {
        return md.update(o);
    }

    @Override
    public boolean delete(Matiere o) {
        return md.delete(o);
    }

    @Override
    public List<Matiere> findAll() {
        return md.findAll();
    }

    @Override
    public Matiere findById(int id) {
        return md.findById(id);

    }

    public List<Matiere> findByEtudiant(Etudiant etudiant) {
        return md.findByEtudiant(etudiant);
    }

}
