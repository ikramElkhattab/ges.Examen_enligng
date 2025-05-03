package org.apache.jsp.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entites.Etudiant;
import entites.User;
import java.util.List;
import entites.Matiere;
import entites.Examen;
import entites.Resultat;
import services.MatiereService;
import services.ExamenService;
import services.ResultatService;

public final class etudiant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    if (user == null || !(user instanceof Etudiant)) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }

    Etudiant etudiant = (Etudiant) user;
    MatiereService matiereService = new MatiereService();
    ExamenService examenService = new ExamenService();
    ResultatService resultatService = new ResultatService();

    // Appels aux méthodes (tu dois créer ou ajuster celles-ci dans les services si elles n'existent pas encore)
    List<Matiere> matieres = matiereService.findByEtudiant(etudiant);
    List<Examen> examens = examenService.findByEtudiant(etudiant);
    List<Resultat> resultats = resultatService.findResultatsByEtudiant(etudiant);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Espace Étudiant</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\">\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color: #f8f9fa;\">\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Espace Étudiant</a>\n");
      out.write("            <div class=\"navbar-text ms-auto\">\n");
      out.write("                Bienvenue <strong>");
      out.print( etudiant.getNom() );
      out.write("</strong>\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\" class=\"btn btn-sm btn-outline-light ms-3\">Déconnexion</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container mt-4\">\n");
      out.write("        <div class=\"row g-4\">\n");
      out.write("\n");
      out.write("            <!-- Mon compte -->\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div class=\"card shadow-sm\">\n");
      out.write("                    <div class=\"card-header bg-info text-white\">\n");
      out.write("                        Mon Compte\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <p><strong>Nom :</strong> ");
      out.print( etudiant.getNom() );
      out.write("</p>\n");
      out.write("                        <p><strong>Email :</strong> ");
      out.print( etudiant.getEmail() );
      out.write("</p>\n");
      out.write("                        <img src=\"https://via.placeholder.com/150\" class=\"rounded\" alt=\"Photo Étudiant\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Matières -->\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"card shadow-sm\">\n");
      out.write("                    <div class=\"card-header bg-success text-white\">Mes Matières</div>\n");
      out.write("                    <ul class=\"list-group list-group-flush\">\n");
      out.write("                        ");
 for (Matiere m : matieres) { 
      out.write("\n");
      out.write("                            <li class=\"list-group-item\">");
      out.print( m.getNom() );
      out.write("</li>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Examens -->\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"card shadow-sm\">\n");
      out.write("                    <div class=\"card-header bg-warning text-white\">Mes Examens</div>\n");
      out.write("                    <ul class=\"list-group list-group-flush\">\n");
      out.write("                        ");
 for (Examen ex : examens) { 
      out.write("\n");
      out.write("                            <li class=\"list-group-item\">");
      out.print( ex.getMatiere().getNom() );
      out.write(" - Durée : ");
      out.print( ex.getDurée() );
      out.write(" min</li>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Résultats -->\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div class=\"card shadow-sm\">\n");
      out.write("                    <div class=\"card-header bg-danger text-white\">Mes Résultats</div>\n");
      out.write("                    <table class=\"table table-striped\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Matière</th>\n");
      out.write("                                <th>Note</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Resultat r : resultats) { 
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print( r.getExamen().getMatiere().getNom() );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( r.getNote() );
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
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
