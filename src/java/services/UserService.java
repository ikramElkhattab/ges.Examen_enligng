package services;

import entites.Admin;
import entites.Etudiant;
import entites.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Service qui gère les opérations liées aux utilisateurs - Version sans JPA
 */
public class UserService {
    
    // Stockage temporaire des utilisateurs en mémoire
    private Map<String, User> users = new HashMap<>();
    private Map<Integer, User> usersById = new HashMap<>();
    
    public UserService() {
        // Créer des utilisateurs de test
        Admin admin = new Admin();
        admin.setId(1);
        admin.setEmail("admin@example.com");
        admin.setMotDePasse("admin123");
        admin.setNom("Admin");
      
        
        Etudiant etudiant = new Etudiant();
        etudiant.setId(2);
        etudiant.setEmail("etudiant@example.com");
        etudiant.setMotDePasse("etudiant123");
        etudiant.setNom("Etudiant");
       
        
        // Ajouter les utilisateurs aux maps
        users.put(admin.getEmail(), admin);
        users.put(etudiant.getEmail(), etudiant);
        usersById.put(admin.getId(), admin);
        usersById.put(etudiant.getId(), etudiant);
    }
    
    /**
     * Authentifie un utilisateur par email et mot de passe
     * @param email Email de l'utilisateur
     * @param motDePasse Mot de passe de l'utilisateur
     * @return User si authentifié, null sinon
     */
    public User authenticate(String email, String motDePasse) {
        User user = users.get(email);
        
        if (user != null && user.getMotDePasse().equals(motDePasse)) {
            return user;
        }
        
        return null;
    }
    
    /**
     * Récupère un utilisateur par son ID
     * @param id ID de l'utilisateur
     * @return User trouvé ou null
     */
    public User getUserById(int id) {
        return usersById.get(id);
    }
    
    /**
     * Vérifie si un utilisateur est un Admin
     * @param user Utilisateur à vérifier
     * @return true si c'est un Admin, false sinon
     */
    public boolean isAdmin(User user) {
        return user instanceof Admin;
    }
    
    /**
     * Vérifie si un utilisateur est un Etudiant
     * @param user Utilisateur à vérifier
     * @return true si c'est un Etudiant, false sinon
     */
    public boolean isEtudiant(User user) {
        return user instanceof Etudiant;
    }
}