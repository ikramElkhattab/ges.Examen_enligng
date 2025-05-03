<%-- 
    Document   : list
    Created on : 3 mai 2025, 04:27:09
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, entites.Matiere" %>
<%@ page import="services.MatiereService" %>
<%
    MatiereService service = new MatiereService();
    List<Matiere> matieres = service.findAll();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Matières</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Liste des Matières</h2>
    <a href="add.jsp" class="btn btn-success mb-3">+ Ajouter une Matière</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Matiere m : matieres) { %>
            <tr>
                <td><%= m.getId() %></td>
                <td><%= m.getNom() %></td>
                <td>
                    <a href="edit.jsp?id=<%= m.getId() %>" class="btn btn-primary btn-sm">Modifier</a>
                    <a href="../MatiereController?action=delete&id=<%= m.getId() %>" class="btn btn-danger btn-sm"
                       onclick="return confirm('Supprimer cette matière ?');">Supprimer</a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>

