<%-- 
    Document   : add
    Created on : 3 mai 2025, 05:03:34
    Author     : hp
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Etudiant, entites.Examen, services.EtudiantService, services.ExamenService" %>
<%
    EtudiantService etudiantService = new EtudiantService();
    ExamenService examenService = new ExamenService();
    List<Etudiant> etudiants = etudiantService.findAll();
    List<Examen> examens = examenService.findAll();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Résultat</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Ajouter un Résultat</h2>
    <form action="../ResultatController" method="post">
        <input type="hidden" name="action" value="add">
        
        <div class="mb-3">
            <label for="etudiantId" class="form-label">Étudiant</label>
            <select name="etudiantId" class="form-control">
                <%
                    for (Etudiant e : etudiants) {
                %>
                    <option value="<%= e.getId() %>"><%= e.getNom() %></option>
                <% } %>
            </select>
        </div>

        <div class="mb-3">
            <label for="examenId" class="form-label">Examen</label>
            <select name="examenId" class="form-control">
                <%
                    for (Examen ex : examens) {
                %>
                    <option value="<%= ex.getId() %>"><%= ex.getMatiere().getNom() %></option>
                <% } %>
            </select>
        </div>

        <div class="mb-3">
            <label for="note" class="form-label">Note</label>
            <input type="number" step="0.01" name="note" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</body>
</html>

