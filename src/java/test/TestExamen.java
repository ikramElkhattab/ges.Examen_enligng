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
    
    // Récupérer l'étudiant
    Etudiant etudiant = ed.findById(1);
    
    if (etudiant != null) {
        List<Examen> examens = ed.findExamen(etudiant);
        
        if (examens.isEmpty()) {
            System.out.println("Aucun examen trouvé pour l'étudiant avec ID 1.");
        } else {
            System.out.println("Examens pour l'étudiant : " + etudiant.getNom());
            for (Examen e : examens) {
                System.out.println("Titre : " + e.getTitre());
                System.out.println("Durée : " + e.getDurée());
                System.out.println("Matière ID : " + e.getMatiere());
                System.out.println("-----");
            }
        }
    } else {
        System.out.println("Étudiant avec ID 1 non trouvé.");
    }
}  

}

