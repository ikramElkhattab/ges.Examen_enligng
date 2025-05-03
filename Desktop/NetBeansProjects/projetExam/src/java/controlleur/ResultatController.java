/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;
import entites.Etudiant;
import entites.Examen;
import entites.Resultat;
import entites.ResultatID;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import services.EtudiantService;
import services.ExamenService;
import services.ResultatService;
/**
 *
 * @author hp
 */


@WebServlet(name = "ResultatController", urlPatterns = {"/ResultatController"})
public class ResultatController extends HttpServlet {

    private final ResultatService resultatService = new ResultatService();
    private final EtudiantService etudiantService = new EtudiantService();
    private final ExamenService examenService = new ExamenService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
        int examenId = Integer.parseInt(request.getParameter("examenId"));
        float note = Float.parseFloat(request.getParameter("note"));

        ResultatID id = new ResultatID(examenId, etudiantId);
        Etudiant etudiant = etudiantService.findById(etudiantId);
        Examen examen = examenService.findById(examenId);

        switch (action) {
            case "add":
                Resultat newResultat = new Resultat();
                newResultat.setId(id);
                newResultat.setNote(note);
                newResultat.setEtudiant(etudiant);
                newResultat.setExamen(examen);
                resultatService.create(newResultat);
                break;

            case "update":
                Resultat existing = resultatService.findById(id);
                if (existing != null) {
                    existing.setNote(note);
                    resultatService.update(existing);
                }
                break;
        }

        response.sendRedirect("resultat/list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
            int examenId = Integer.parseInt(request.getParameter("examenId"));

            ResultatID id = new ResultatID(examenId, etudiantId);
            Resultat r = resultatService.findById(id);
            if (r != null) {
                resultatService.delete(r);
            }
        }

        response.sendRedirect("resultat/list.jsp");
    }
}
