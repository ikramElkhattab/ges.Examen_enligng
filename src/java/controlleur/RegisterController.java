/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import entites.Etudiant;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;

/**
 *
 * @author hp
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private UserService userService = new UserService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("motDePasse");
        String confirmPassword = request.getParameter("confirmPassword");
        
        // Validation basique
        if (!password.equals(confirmPassword)) {
            request.setAttribute("erreur", "Les mots de passe ne correspondent pas");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        // Vérifier si l'email existe déjà
        if (userService.findByEmail(email) != null) {
            request.setAttribute("erreur", "Cet email est déjà utilisé");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        // Créer le Etudiant
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setEmail(email);
        etudiant.setMotDePasse(password); // Devrait être hashé en production
        
        if (userService.create(etudiant)) {
            response.sendRedirect("login.jsp?success=Compte créé avec succès");
        } else {
            request.setAttribute("erreur", "Erreur lors de la création du compte");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
