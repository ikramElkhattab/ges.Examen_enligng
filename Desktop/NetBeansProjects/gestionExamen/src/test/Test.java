/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.EtudiantDao;
import dao.ExamenDao;
import dao.MatiereDao;
import dao.ResultatDao;
import entites.Etudiant;
import entites.Examen;
import entites.Matiere;
import entites.Resultat;
import java.util.Date;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class Test {

    public static void main(String[] args) {
        // Initialisation de Hibernate
        HibernateUtil.getSessionFactory();
        // Test MatiereDao
        MatiereDao matiereDao = new MatiereDao();
        Matiere matiere = new Matiere("Mathematics");
        matiereDao.create(matiere);
        System.out.println("Matière créée : " + matiere.getNom());
        
        // Test EtudiantDao
        EtudiantDao etudiantDao = new EtudiantDao(); 
        
        // Remplacez par des valeurs appropriées
        Date dateNaissance = new Date(); // Utilisez une date spécifique si nécessaire
        String nom = "John Doe";
        String email = "john.doe@example.com";
        String motDePasse = "securePassword";

        // Initialisation de l'étudiant avec tous les paramètres
        Etudiant etudiant = new Etudiant(dateNaissance, nom, email, motDePasse);
        
        // Sauvegarde de l'étudiant
        etudiantDao.create(etudiant); 
        System.out.println("Étudiant créé : " + etudiant.getNom());


        // Test ExamenDao
        ExamenDao examenDao = new ExamenDao();
        int durée = 120;
        Examen examen = new Examen("Examen de Mathématiques", durée, matiere);
        examenDao.create(examen);
        System.out.println("Examen créé : " + examen.getTitre());
        
       // Test ResultatDao
        ResultatDao resultatDao = new ResultatDao();
        Float note = 85.0f; // Note pour le résultat
        Resultat resultat = new Resultat(note, examen, etudiant); // Utilisez etudiant ici
        resultatDao.create(resultat);
        System.out.println("Résultat créé : " + resultat.getNote() + " pour l'examen " + examen.getTitre());
        // Affichage des examens associés à une matière
        System.out.println("Examens pour la matière " + matiere.getNom() + ":");
        for (Examen ex : matiereDao.findById(matiere.getId()).getExamens()) {
            System.out.println(ex.getTitre());
        }
        // Nettoyage
        resultatDao.delete(resultat);
        examenDao.delete(examen);
        matiereDao.delete(matiere);
         etudiantDao.delete(etudiant);

    }
}
