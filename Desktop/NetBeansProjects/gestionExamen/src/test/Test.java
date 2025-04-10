package test;

import dao.EtudiantDao;
import dao.ExamenDao;
import dao.MatiereDao;
import dao.ResultatDao;
import entites.Etudiant;
import entites.Examen;
import entites.Matiere;
import entites.Resultat;
import entites.ResultatID;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.HibernateUtil;
import org.hibernate.Session;

public class Test {

    public static void main(String[] args) {
        // Open a Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            // Initialize DAOs
            MatiereDao matiereDao = new MatiereDao();
            EtudiantDao etudiantDao = new EtudiantDao();
            ExamenDao examenDao = new ExamenDao();
            ResultatDao resultatDao = new ResultatDao();

            // Create and save subjects
            List<Matiere> matieres = new ArrayList<>();
            matieres.add(new Matiere("Mathematics"));
            matieres.add(new Matiere("Physics"));
            matieres.add(new Matiere("Chemistry"));

            for (Matiere matiere : matieres) {
                matiereDao.create(matiere);
                System.out.println("Matière créée : " + matiere.getNom());
            }

            // Create and save students
            List<Etudiant> etudiants = new ArrayList<>();
            etudiants.add(new Etudiant(new Date(), "John Doe", "john.doe@example.com", "securePassword"));
            etudiants.add(new Etudiant(new Date(), "Jane Smith", "jane.smith@example.com", "securePassword123"));
            etudiants.add(new Etudiant(new Date(), "Alice Johnson", "alice.johnson@example.com", "password456"));

            for (Etudiant etudiant : etudiants) {
                etudiantDao.create(etudiant);
                System.out.println("Étudiant créé : " + etudiant.getNom());
            }

            // Create and save exams
            List<Examen> examens = new ArrayList<>();
            examens.add(new Examen("Test Mathématiques", 120, matieres.get(0)));
            examens.add(new Examen("Test Physique", 90, matieres.get(1)));
            examens.add(new Examen("Test Chimie", 150, matieres.get(2)));

            for (Examen examen : examens) {
                examenDao.create(examen);
                System.out.println("Examen créé : " + examen.getTitre());
            }

            // Create and save results using ResultatID
            for (Etudiant etudiant : etudiants) {
                for (Examen examen : examens) {
                    Float note = (float) (Math.random() * 100); 
                    ResultatID resultatID = new ResultatID(examen.getId(), etudiant.getId());
                    Resultat resultat = new Resultat();
                    resultat.setId(resultatID);
                    resultat.setNote(note);
                    resultatDao.create(resultat);
                    System.out.println("Résultat créé : " + resultat.getNote() + " pour l'examen " + examen.getTitre());
                }
            }

            // Filtrage des examens par durée
            System.out.println("Examens d'une durée supérieure à 100 minutes :");
            for (Examen examen : examens) {
                if (examen.getDurée() > 100) {
                    System.out.println(examen.getTitre());
                }
            }

            // Filtrage des résultats par note
            System.out.println("Résultats supérieurs à 50 :");
            for (Resultat resultat : resultatDao.findAll()) {
                if (resultat.getNote() > 50) {
                    System.out.println("Note : " + resultat.getNote() + " pour l'examen " + resultat.getExamen().getTitre());
                }
            }

            // Commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}