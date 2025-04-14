/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.EtudiantDao;
import entites.Etudiant;
import entites.Examen;
import java.util.List;

/**
 *
 * @author hp
 */
public class TestExamen {
    

    public static void main(String[] args) {
        EtudiantDao ed = new EtudiantDao();
        for(Examen e :ed.findExamen(ed.findById(1)))
             System.out.println(e.getTitre());        
    }
}
