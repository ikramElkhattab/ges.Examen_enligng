<%-- 
    Document   : list
    Created on : 3 mai 2025, 04:39:05
    Author     : hp
--%>

<%@page import="entites.Matiere"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, entites.Examen" %>
<%@ page import="services.ExamenService" %>
<%
    ExamenService service = new ExamenService();
    List<Examen> examens = service.findAll();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Examens</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Liste des Examens</h2>
    <a href="add.jsp" class="btn btn-success mb-3">+ Ajouter un Examen</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Durée</th>
            <th>Matière</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Examen e : examens) { %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getDurée()%></td>
                <td><%= e.getMatiere().getNom() %></td>
                <td>
                    <a href="edit.jsp?id=<%= e.getId() %>" class="btn btn-primary btn-sm">Modifier</a>
                    <a href="../ExamenController?action=delete&id=<%= e.getId() %>" class="btn btn-danger btn-sm"
                       onclick="return confirm('Supprimer cet examen ?');">Supprimer</a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>

