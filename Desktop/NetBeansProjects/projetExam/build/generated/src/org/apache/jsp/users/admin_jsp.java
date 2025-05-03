package org.apache.jsp.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entites.Admin;
import entites.User;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
    Admin admin = (Admin) user;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Espace Administrateur</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-danger\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Gestion des Examens</a>\n");
      out.write("                <div class=\"navbar-text ms-auto\">\n");
      out.write("                    Bienvenue <strong>");
      out.print( admin.getNom());
      out.write("</strong>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\" class=\"btn btn-sm btn-outline-light ms-3\">Déconnexion</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container mt-4\">\n");
      out.write("            <h1>Espace Administrateur</h1>\n");
      out.write("            <div class=\"card mt-4\">\n");
      out.write("                <div class=\"card-header\">\n");
      out.write("                    Tableau de bord\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <p><strong>Email :</strong> ");
      out.print( admin.getEmail());
      out.write("</p>\n");
      out.write("                    <div class=\"mt-3\">\n");
      out.write("                        <a href=\"\" \n");
      out.write("                           class=\"btn btn-primary\">\n");
      out.write("                            <i class=\"bi bi-people-fill\"></i> Gérer les utilisateurs\n");
      out.write("                        </a>                    \n");
      out.write("                        <!-- Cartes de gestion -->\n");
      out.write("                        <div class=\"row mt-4 row-cols-1 row-cols-md-2 g-4\">\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <div class=\"card border-primary h-100\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5 class=\"card-title\">Gestion des Étudiants</h5>\n");
      out.write("                                        <p class=\"card-text\">Ajoutez, modifiez ou supprimez les comptes des étudiants.</p>\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/etudiant/list.jsp\" class=\"btn btn-primary\">Gérer</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <div class=\"card border-success h-100\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5 class=\"card-title\">Gestion des Matières</h5>\n");
      out.write("                                        <p class=\"card-text\">Organisez les matières disponibles pour les examens.</p>\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/matiere/list.jsp\" class=\"btn btn-success\">Gérer</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <div class=\"card border-warning h-100\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5 class=\"card-title\">Gestion des Examens</h5>\n");
      out.write("                                        <p class=\"card-text\">Planifiez, modifiez ou supprimez des examens.</p>\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/examen/list.jsp\" class=\"btn btn-warning\">Gérer</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <div class=\"card border-danger h-100\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5 class=\"card-title\">Résultats</h5>\n");
      out.write("                                        <p class=\"card-text\">Consultez les résultats des examens des étudiants.</p>\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resultat/list.jsp\" class=\"btn btn-danger\">Gérer</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Graphique : Examens par Matière -->\n");
      out.write("                        <div class=\"card mt-5\">\n");
      out.write("                            <div class=\"card-header\">\n");
      out.write("                                Statistiques : Examens par Matière\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <canvas id=\"examChart\" width=\"400\" height=\"200\"></canvas>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Chart.js -->\n");
      out.write("                        <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
      out.write("                        <script>\n");
      out.write("                                    const ctx = document.getElementById('examChart').getContext('2d');\n");
      out.write("                                    const examChart = new Chart(ctx, {\n");
      out.write("                                    type: 'bar',\n");
      out.write("                                            data: {\n");
      out.write("                                            labels: ['Maths', 'Physique', 'Chimie', 'Informatique'],\n");
      out.write("                                                    datasets: [{\n");
      out.write("                                                    label: 'Nombre d\\'examens',\n");
      out.write("                                                            data: [5, 3, 4, 6], // Remplace par des valeurs dynamiques si possible\n");
      out.write("                                                            backgroundColor: ['#0d6efd', '#198754', '#ffc107', '#dc3545'],\n");
      out.write("                                                            borderWidth: 1\n");
      out.write("                                                    }]\n");
      out.write("                                            },\n");
      out.write("                                            options: {\n");
      out.write("                                            responsive: true,\n");
      out.write("                                                    scales: {\n");
      out.write("                                                    y: {\n");
      out.write("                                                    beginAtZero: true,\n");
      out.write("                                                            ticks: {\n");
      out.write("                                                            stepSize: 1\n");
      out.write("                                                            }\n");
      out.write("                                                    }\n");
      out.write("                                                    }\n");
      out.write("                                            }\n");
      out.write("                                    });\n");
      out.write("                        </script>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
