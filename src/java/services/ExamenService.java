/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.MatiereDao;
import entites.Matiere;
import java.util.List;

/**
 *
 * @author hp
 */
public class ExamenService implements IService<Matiere>{

    private final MatiereDao dao;

    public ExamenService() {
        this.dao = new MatiereDao();
    }

   

    @Override
    public boolean create(Matiere o) {
        return dao.create(o);
    }

    @Override
    public boolean delete(Matiere o) {
        return dao.delete(o);
    }

    @Override
    public boolean update(Matiere o) {
        return dao.update(o);
    }

    @Override
    public List<Matiere> findAll() {
        return dao.findAll();
    }

    @Override
    public Matiere findById(int id) {
        return dao.findById(id);
    }

   
}