package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entites.Admin;
import entites.Etudiant;
import entites.User;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Connexion - Gestion des Formations</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f8f9fa;\n");
      out.write("        }\n");
      out.write("        .login-container {\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin: 100px auto;\n");
      out.write("            padding: 20px;\n");
      out.write("            background: white;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        .create-account {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            padding-top: 15px;\n");
      out.write("            border-top: 1px solid #eee;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"login-container\">\n");
      out.write("            <h2 class=\"text-center mb-4\">Connexion</h2>\n");
      out.write("            \n");
      out.write("            ");
 if (request.getAttribute("erreur") != null) { 
      out.write("\n");
      out.write("                <div class=\"alert alert-danger\">\n");
      out.write("                    ");
      out.print( request.getAttribute("erreur") );
      out.write("\n");
      out.write("                </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("             ");
      out.write("\n");
      out.write("            ");
 if (request.getParameter("logout") != null) { 
      out.write("\n");
      out.write("                <div class=\"alert alert-success\">\n");
      out.write("                    Vous avez été déconnecté avec succès.\n");
      out.write("                </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            \n");
      out.write("            <form action=\"LoginController\" method=\"post\">\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label for=\"email\" class=\"form-label\">Email</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label for=\"motDePasse\" class=\"form-label\">Mot de passe</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"motDePasse\" name=\"motDePasse\" required>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary w-100\">Se connecter</button>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            <div class=\"create-account\">\n");
      out.write("                <p>Nouveau Etudiant ? <a href=\"register.jsp\">Créer un compte</a></p>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
