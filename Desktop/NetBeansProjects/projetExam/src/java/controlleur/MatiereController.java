/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;
import entites.Matiere;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.MatiereService;
/**
 *
 * @author hp
 */
@WebServlet(name = "MatiereController", urlPatterns = {"/MatiereController"})
public class MatiereController extends HttpServlet {

    private final MatiereService service = new MatiereService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "add":
                Matiere m1 = new Matiere();
                m1.setNom(request.getParameter("nom"));
                service.create(m1);
                break;

            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Matiere m2 = service.findById(id);
                m2.setNom(request.getParameter("nom"));
                service.update(m2);
                break;
        }

        response.sendRedirect("matiere/list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("delete".equals(request.getParameter("action"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            Matiere m = service.findById(id);
            if (m != null) {
                service.delete(m);
            }
        }

        response.sendRedirect("matiere/list.jsp");
    }
}
