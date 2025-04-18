package org.apache.jsp.WEB_002dINF.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Tableau de bord Admin</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        header {\n");
      out.write("            background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        h1 {\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("        .user-info {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        .user-info p {\n");
      out.write("            margin-right: 20px;\n");
      out.write("        }\n");
      out.write("        .logout {\n");
      out.write("            background-color: #e74c3c;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        .content {\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("        .dashboard-title {\n");
      out.write("            color: #333;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            background-color: white;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);\n");
      out.write("            padding: 20px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .card h3 {\n");
      out.write("            color: #333;\n");
      out.write("            margin-top: 0;\n");
      out.write("        }\n");
      out.write("        .navigation {\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .navigation a {\n");
      out.write("            display: inline-block;\n");
      out.write("            margin-right: 10px;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("        }\n");
      out.write("        .navigation a:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Administration</h1>\n");
      out.write("        <div class=\"user-info\">\n");
      out.write("            <p>Bienvenue, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.nom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('(');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.role}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</p>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\" class=\"logout\">Déconnexion</a>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <h2 class=\"dashboard-title\">Tableau de bord Administrateur</h2>\n");
      out.write("            \n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3>Gestion des Étudiants</h3>\n");
      out.write("                <p>Gérez les comptes étudiants, leurs inscriptions et leurs résultats.</p>\n");
      out.write("                <div class=\"navigation\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/etudiants\">Liste des Étudiants</a>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/etudiants/create\">Ajouter un Étudiant</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3>Gestion des Examens</h3>\n");
      out.write("                <p>Créez et gérez les examens pour les différentes matières.</p>\n");
      out.write("                <div class=\"navigation\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/examens\">Liste des Examens</a>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/examens/create\">Créer un Examen</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3>Gestion des Matières</h3>\n");
      out.write("                <p>Ajoutez et modifiez les matières disponibles.</p>\n");
      out.write("                <div class=\"navigation\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/matieres\">Liste des Matières</a>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/matieres/create\">Ajouter une Matière</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h3>Gestion des Résultats</h3>\n");
      out.write("                <p>Consultez et modifiez les résultats des examens.</p>\n");
      out.write("                <div class=\"navigation\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/resultats\">Tous les Résultats</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
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
