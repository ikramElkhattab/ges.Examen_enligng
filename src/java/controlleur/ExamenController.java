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
import services.ExamenService;

/**
 *
 * @author hp
 */
@WebServlet(name = "ExamenController", urlPatterns = {"/ExamenController"})
public class ExamenController extends HttpServlet {

    private ExamenService es;

    @Override
    public void init() throws ServletException {
        super.init();
        es = new ExamenService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        if (op == null) {
            // Création ou mise à jour
            String id = request.getParameter("id");
            String nom = request.getParameter("nom");

            Matiere m = new Matiere(nom);

            if (id == null || id.isEmpty()) {
                // Création
                es.create(m);
            } else {
                // Mise à jour
                m.setId(Integer.parseInt(id));
                es.update(m);
            }

            response.sendRedirect("formations/page.jsp");

        } else if (op.equals("delete")) {
            String id = request.getParameter("id");
            es.delete(es.findById(Integer.parseInt(id)));
            response.sendRedirect("examen/page.jsp");

        } else if (op.equals("update")) {
            String id = request.getParameter("id");
            Matiere m = es.findById(Integer.parseInt(id));
            response.sendRedirect("examen/page.jsp?id=" + m.getId() + "&nom=" + m.getNom());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ExamenController";
    }
}
