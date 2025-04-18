package controlleur;

import entites.User;
import entites.Admin;
import entites.Etudiant;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;

/**
 * Servlet qui gère l'authentification des utilisateurs
 * @author hp
 */
@WebServlet(name = "Authentification", urlPatterns = {"/login"})
public class Authentification extends HttpServlet {
    
    private UserService userService;
    
    @Override
    public void init() {
        userService = new UserService();
    }
    
    /**
     * Traite les requêtes pour la servlet Authentification
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Si c'est une requête GET, afficher le formulaire de connexion
        if (request.getMethod().equals("GET")) {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        // Si c'est une requête POST, traiter l'authentification
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        
        // Validation des champs
        if (email == null || email.isEmpty() || motDePasse == null || motDePasse.isEmpty()) {
            request.setAttribute("errorMessage", "Veuillez remplir tous les champs.");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        // Authentification de l'utilisateur
        User user = userService.authenticate(email, motDePasse);
        
        if (user != null) {
            // Créer une session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            // Rediriger selon le type d'utilisateur
            if (user instanceof Admin) {
                session.setAttribute("userType", "admin");
                response.sendRedirect(request.getContextPath() + "/admin/dashboard");
            } else if (user instanceof Etudiant) {
                session.setAttribute("userType", "etudiant");
                response.sendRedirect(request.getContextPath() + "/etudiant/dashboard");
            }
        } else {
            // Authentification échouée
            request.setAttribute("errorMessage", "Email ou mot de passe incorrect.");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet gérant l'authentification des utilisateurs";
    }// </editor-fold>
}