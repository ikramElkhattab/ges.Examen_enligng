/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import entites.Examen;
import entites.Matiere;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ExamenService;
import services.MatiereService;

/**
 *
 * @author hp
 */
@WebServlet(name = "ExamenController", urlPatterns = {"/ExamenController"})
public class ExamenController extends HttpServlet {

    private final ExamenService service = new ExamenService();
    private final MatiereService matiereService = new MatiereService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "add":
                Examen e1 = new Examen();
                int duree1 = Integer.parseInt(request.getParameter("durée"));
                e1.setDurée(duree1);
                int matId1 = Integer.parseInt(request.getParameter("matiereId"));
                e1.setMatiere(matiereService.findById(matId1));
                service.create(e1);
                break;

            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Examen e2 = service.findById(id);
                int duree2 = Integer.parseInt(request.getParameter("durée"));
                e2.setDurée(duree2);
                int matId2 = Integer.parseInt(request.getParameter("matiereId"));
                e2.setMatiere(matiereService.findById(matId2));
                service.update(e2);
                break;
        }

        response.sendRedirect("examen/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("delete".equals(request.getParameter("action"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            Examen e = service.findById(id);
            if (e != null) {
                service.delete(e);
            }
        }

        response.sendRedirect("examen/list.jsp");
    }
}
