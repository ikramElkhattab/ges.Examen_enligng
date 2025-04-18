package controlleur;

import entites.Etudiant;
import entites.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;

@WebServlet(name = "EtudiantDashboardServlet", urlPatterns = {"/etudiant/dashboard"})
public class EtudiantDashboardServlet extends HttpServlet {
    
    private UserService userService;
    
    @Override
    public void init() {
        userService = new UserService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            
            if (userService.isEtudiant(user)) {
                Etudiant etudiant = (Etudiant) user;
                request.setAttribute("etudiant", etudiant);
                request.getRequestDispatcher("/WEB-INF/etudiant/dashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}