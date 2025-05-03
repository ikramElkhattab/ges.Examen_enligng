<%-- 
    Document   : edit
    Created on : 3 mai 2025, 04:42:14
    Author     : hp
--%>

<%@ page import="services.ExamenService, services.MatiereService" %>
<%@ page import="entites.Examen, entites.Matiere" %>
<%@ page import="java.util.List" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ExamenService examenService = new ExamenService();
    Examen examen = examenService.findById(id);

    MatiereService matiereService = new MatiereService();
    List<Matiere> matieres = matiereService.findAll();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Modifier Examen</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Modifier Examen</h2>
    <form action="../ExamenController" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="<%= examen.getId() %>" />
        <div class="mb-3">
            <label>Durée</label>
            <input type="number" class="form-control" id="duree" name="durée" required value="<%= (examen != null ? examen.getDurée() : "") %>">
        </div>
        <div class="mb-3">
            <label>Matière</label>
            <select name="matiereId" class="form-control" required>
                <% for (Matiere m : matieres) { %>
                    <option value="<%= m.getId() %>" <%= m.getId() == examen.getMatiere().getId() ? "selected" : "" %>>
                        <%= m.getNom() %>
                    </option>
                <% } %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
        <a href="list.jsp" class="btn btn-secondary">Annuler</a>
    </form>
</div>
</body>
</html>
