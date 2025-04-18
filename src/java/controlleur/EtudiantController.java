/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import entites.Etudiant;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.EtudiantService;

/**
 *
 * @author hp
 */
@WebServlet(name = "EtudiantController", urlPatterns = {
    "/admin/etudiants", 
    "/admin/etudiants/create",
    "/admin/etudiants/edit",
    "/admin/etudiants/delete"
})
public class EtudiantController extends HttpServlet {
    private EtudiantService etudiantService;
    
    @Override
    public void init() {
        etudiantService = new EtudiantService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        
        if (requestURI.endsWith("/admin/etudiants")) {
            // Afficher la liste des étudiants
            List<Etudiant> etudiants = etudiantService.getAllEtudiants();
            request.setAttribute("etudiants", etudiants);
            request.getRequestDispatcher("/WEB-INF/admin/etudiants.jsp").forward(request, response);
        } 
        else if (requestURI.endsWith("/admin/etudiants/create")) {
            // Afficher le formulaire d'ajout
            request.getRequestDispatcher("/WEB-INF/admin/etudiant-form.jsp").forward(request, response);
        }
        else if (requestURI.contains("/admin/etudiants/edit")) {
            // Récupérer l'étudiant à modifier
            int id = Integer.parseInt(request.getParameter("id"));
            Etudiant etudiant = etudiantService.getEtudiantById(id);
            request.setAttribute("etudiant", etudiant);
            request.getRequestDispatcher("/WEB-INF/admin/etudiant-form.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        
        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        
        if (requestURI.endsWith("/admin/etudiants/create")) {
            // Créer un nouvel étudiant
            Etudiant etudiant = new Etudiant();
            etudiant.setNom(nom);
            etudiant.setEmail(email);
            etudiant.setMotDePasse(motDePasse);
            
            etudiantService.saveEtudiant(etudiant);
            response.sendRedirect(request.getContextPath() + "/admin/etudiants");
        }
        else if (requestURI.contains("/admin/etudiants/edit")) {
            // Modifier un étudiant existant
            int id = Integer.parseInt(request.getParameter("id"));
            Etudiant etudiant = etudiantService.getEtudiantById(id);
            etudiant.setNom(nom);
            etudiant.setEmail(email);
            if (!motDePasse.isEmpty()) {
                etudiant.setMotDePasse(motDePasse);
            }
            
            etudiantService.updateEtudiant(etudiant);
            response.sendRedirect(request.getContextPath() + "/admin/etudiants");
        }
        else if (requestURI.contains("/admin/etudiants/delete")) {
            // Supprimer un étudiant
            int id = Integer.parseInt(request.getParameter("id"));
            etudiantService.deleteEtudiant(id);
            response.sendRedirect(request.getContextPath() + "/admin/etudiants");
        }
    }
}
