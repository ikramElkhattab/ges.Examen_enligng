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
import services.EtudiantService;

/**
 *
 * @author hp
 */
@WebServlet(name = "EtudiantController", urlPatterns = {"/EtudiantController"})
public class EtudiantController extends HttpServlet {

    private final EtudiantService service = new EtudiantService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "add":
                Etudiant e1 = new Etudiant();
                e1.setNom(request.getParameter("nom"));
                e1.setEmail(request.getParameter("email"));
                e1.setMotDePasse(request.getParameter("motDePasse"));
                service.create(e1);
                break;

            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Etudiant e2 = service.findById(id);
                e2.setNom(request.getParameter("nom"));
                e2.setEmail(request.getParameter("email"));
                e2.setMotDePasse(request.getParameter("motDePasse"));
                service.update(e2);
                break;
        }

        response.sendRedirect("etudiant/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Etudiant e = service.findById(id);
            if (e != null) {
                service.delete(e);
            }
        }

        response.sendRedirect("etudiant/list.jsp");
    }
}

