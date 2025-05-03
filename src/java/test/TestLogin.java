/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDao;
import entites.User;

/**
 *
 * @author hp
 */
public class TestLogin {
   public static void main(String[] args) {
        UserDao userDao = new UserDao();

        String email = "john.doe@example.com"; // utilisateur existant
        String motDePasse = "securePassword";  // mot de passe correspondant

        User user = userDao.findByEmailAndPassword(email, motDePasse);
        
        if (user != null) {
            System.out.println("Connexion réussie ! Bienvenue " + user.getNom());
        } else {
            System.out.println("Échec de la connexion. Email ou mot de passe incorrect.");
        }
    }  
}
