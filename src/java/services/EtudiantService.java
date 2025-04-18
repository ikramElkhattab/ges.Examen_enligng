/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Etudiant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public class EtudiantService{
    private Map<Integer, Etudiant> etudiants = new HashMap<>();
    private int nextId = 1;
    
    public EtudiantService() {
        // Ajouter quelques étudiants de test
        Etudiant e1 = new Etudiant();
        e1.setId(nextId++);
        e1.setNom("Dupont Jean");
        e1.setEmail("jean.dupont@example.com");
        e1.setMotDePasse("Jean123");
        
        Etudiant e2 = new Etudiant();
        e2.setId(nextId++);
        e2.setNom("Martin Sophie");
        e2.setEmail("sophie.martin@example.com");
        e2.setMotDePasse("Sophie123");
        
        etudiants.put(e1.getId(), e1);
        etudiants.put(e2.getId(), e2);
    }
    
    public List<Etudiant> getAllEtudiants() {
        return new ArrayList<>(etudiants.values());
    }
    
    public Etudiant getEtudiantById(int id) {
        return etudiants.get(id);
    }
    
    public void saveEtudiant(Etudiant etudiant) {
        etudiant.setId(nextId++);
        etudiants.put(etudiant.getId(), etudiant);
    }
    
    public void updateEtudiant(Etudiant etudiant) {
        etudiants.put(etudiant.getId(), etudiant);
    }
    
    public void deleteEtudiant(int id) {
        etudiants.remove(id);
    }
}
