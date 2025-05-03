/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
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
@WebServlet("/examenChartData")
public class ExamenChartDataServlet extends HttpServlet {

    private final ExamenService examenService = new ExamenService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Long> data = new ExamenService().countByMatiere();
        String json = new Gson().toJson(data);
        request.setAttribute("chartData", json);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}
